package com.santos.bankchallengue.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.santos.bankchallengue.presentation.util.LoginFailure
import com.santos.bankchallengue.presentation.util.ResultType
import kotlinx.coroutines.tasks.await

class UserRepositoryImpl(private val firebaseAuth: FirebaseAuth) : UserRepository {

    override suspend fun login(user: String, pass: String): ResultType<String, LoginFailure> {
        try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(user, pass).await()
            val username =
                authResult.user ?: return ResultType.Error(LoginFailure.UnexpectedFailure)
            return ResultType.Success(username.uid)
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            return ResultType.Error(LoginFailure.InvalidCredentialFailure)
        } catch (e: Exception) {
            return ResultType.Error(LoginFailure.UnexpectedFailure)
        }
    }
}