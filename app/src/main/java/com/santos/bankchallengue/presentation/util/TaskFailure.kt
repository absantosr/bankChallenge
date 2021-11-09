package com.santos.bankchallengue.presentation.util

sealed class TaskFailure {

    object InvalidCredentialFailure: TaskFailure()
    object UnexpectedFailure: TaskFailure()
}