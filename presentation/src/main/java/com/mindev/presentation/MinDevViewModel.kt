package com.mindev.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

abstract class MinDevViewModel : ViewModel() {

    val errorHandler = CoroutineExceptionHandler(::errorListener)

    abstract fun errorListener(coroutineContext: CoroutineContext, message: Throwable)
}
