package com.santos.bankchallengue.presentation.util

sealed class ResultType<out T, out Y> {

    data class Success<T,Y>(val data: T) : ResultType<T, Y>()
    data class Error<T,Y>(val error: Y) : ResultType<T, Y>()
}
