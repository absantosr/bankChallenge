package com.santos.bankchallengue.presentation.util

sealed class LoginState {

    object Loading : LoginState()

    data class Success(val uid: String) : LoginState()
    data class Error(val error: LoginFailure) : LoginState()
}
