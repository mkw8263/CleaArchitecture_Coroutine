package com.sample_coroutine_android.di.module.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mindev.presentation.ui.main.MainActivityViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel() as T
    }
}
