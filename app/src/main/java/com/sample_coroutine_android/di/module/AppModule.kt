package com.sample_coroutine_android.di.module

import android.content.Context
import com.sample_coroutine_android.MinDevApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: MinDevApplication) {
    @Provides
    fun provideApplicationContext(): Context = application.applicationContext
}
