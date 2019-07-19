package com.sample_coroutine_android.di.module.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mindev.domain.news.NewsUseCase
import com.mindev.presentation.ui.main.MainActivityViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor(val newsUseCase: NewsUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(newsUseCase) as T
    }
}
