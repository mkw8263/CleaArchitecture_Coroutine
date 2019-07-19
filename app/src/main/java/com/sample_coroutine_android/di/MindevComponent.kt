package com.sample_coroutine_android.di

import com.sample_coroutine_android.MinDevApplication
import com.sample_coroutine_android.di.module.*
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetWorkModule::class,
        ViewModelBindingModule::class,
        ViewModelFactoryBindModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ActivityBindingModule::class]
)
interface MindevComponent {
    fun inject(app: MinDevApplication)
}
