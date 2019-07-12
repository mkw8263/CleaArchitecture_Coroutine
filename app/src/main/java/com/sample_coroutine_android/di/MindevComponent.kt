package com.sample_coroutine_android.di

import com.sample_coroutine_android.MinDevApplication
import com.sample_coroutine_android.di.module.ActivityBindingModule
import com.sample_coroutine_android.di.module.NetWorkModule
import com.sample_coroutine_android.di.module.ViewModelBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetWorkModule::class,
        ViewModelBindingModule::class,
        ActivityBindingModule::class]
)
interface MindevComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: MinDevApplication): Builder

        fun build(): MindevComponent
    }

    fun inject(app: MinDevApplication)
}
