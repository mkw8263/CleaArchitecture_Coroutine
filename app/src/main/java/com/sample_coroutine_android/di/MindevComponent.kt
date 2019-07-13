package com.sample_coroutine_android.di

import com.sample_coroutine_android.MinDevApplication
import com.sample_coroutine_android.di.module.ActivityBindingModule
import com.sample_coroutine_android.di.module.NetWorkModule
import com.sample_coroutine_android.di.module.ViewModelBindingModule
import com.sample_coroutine_android.di.module.ViewModelFactoryBindModule
import com.sample_coroutine_android.di.qualifier.PerApplication
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetWorkModule::class,
        ViewModelBindingModule::class,
        ViewModelFactoryBindModule::class,
        ActivityBindingModule::class]
)
interface MindevComponent {
    fun inject(app: MinDevApplication)
}
