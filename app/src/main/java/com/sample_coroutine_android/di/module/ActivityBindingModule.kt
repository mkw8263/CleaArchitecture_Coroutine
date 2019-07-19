package com.sample_coroutine_android.di.module

import com.mindev.presentation.ui.main.MainActivity
import com.sample_coroutine_android.di.qualifier.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindingMainActivity(): MainActivity
}
