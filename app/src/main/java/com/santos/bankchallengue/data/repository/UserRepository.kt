package com.santos.bankchallengue.data.repository

import com.santos.bankchallengue.presentation.util.LoginFailure
import com.santos.bankchallengue.presentation.util.ResultType

interface UserRepository {

    suspend fun login(
        user: String,
        pass: String
    ) : ResultType<String, LoginFailure>
}