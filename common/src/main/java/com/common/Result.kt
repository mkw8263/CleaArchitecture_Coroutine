package com.common

sealed class Result<out E, out V> {
    data class Success<out V>(val value: V) : Result<Nothing, V>()
    object Loading : Result<Nothing, Nothing>()
    data class Error<out E>(val error: E) : Result<E, Nothing>()
}
