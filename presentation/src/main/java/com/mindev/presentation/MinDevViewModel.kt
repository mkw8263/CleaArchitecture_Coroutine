package com.mindev.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import java.io.IOException

open class MinDevViewModel : ViewModel() {

    val errorHandler = CoroutineExceptionHandler { _, exception ->
        when (exception) {
            is IOException -> Log.e("network error", "error !!")
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}
