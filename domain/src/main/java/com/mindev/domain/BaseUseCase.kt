package com.mindev.domain

import com.common.Either
import com.common.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseUseCase<out Type, in Params> where Type : Any {
    abstract suspend fun execute(params: Params): Either<Failure, Type>

    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        result: (Either<Failure, Type>) -> Unit
    ) {
        val backgroundJob = scope.async { execute(params) }
        scope.launch { result(backgroundJob.await()) }
    }
}