package com.santos.bankchallengue.presentation.util

sealed class LoginFailure {
    object InvalidCredentialFailure: LoginFailure()
    object UnexpectedFailure: LoginFailure()
}