package com.santos.bankchallengue.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.santos.bankchallengue.data.repository.UserRepositoryImpl
import com.santos.bankchallengue.presentation.util.LiveEvent
import com.santos.bankchallengue.presentation.util.LoginState
import com.santos.bankchallengue.presentation.util.ResultType
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

    private val userRepository = UserRepositoryImpl(FirebaseAuth.getInstance())

    private val _userLiveData = LiveEvent<LoginState>()
    val userAuthLiveData: LiveData<LoginState> get() = _userLiveData

    fun login(user: String, pass: String) {
        _userLiveData.value = LoginState.Loading
        viewModelScope.launch {
            when (val result = userRepository.login(user, pass)) {
                is ResultType.Success -> {
                    Log.d("LoginSuccess", result.data)
                    _userLiveData.value = LoginState.Success(result.data)
                }
                is ResultType.Error -> {
                    Log.d("LoginError", result.toString())
                    _userLiveData.value = LoginState.Error(result.error)
                }
            }
        }
    }
}