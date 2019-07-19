package com.mindev.domain

internal interface BaseUseCase<Type, Param> {
    suspend fun execute(params: Param? = null): Type
}
