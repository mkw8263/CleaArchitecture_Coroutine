package com.mindev.domain

import com.common.Result

internal interface BaseUseCase<Type, Param> {
    suspend fun execute(params: Param? = null): Result<Exception, Type>
}
