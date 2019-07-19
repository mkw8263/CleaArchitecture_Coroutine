package com.sample_coroutine_android.di.module

import androidx.lifecycle.ViewModel
import com.mindev.presentation.ui.main.MainActivityViewModel
import com.sample_coroutine_android.di.qualifier.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class  ViewModelBindingModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}
