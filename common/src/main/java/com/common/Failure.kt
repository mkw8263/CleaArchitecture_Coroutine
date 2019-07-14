package com.common

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
}