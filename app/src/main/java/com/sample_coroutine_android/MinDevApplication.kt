package com.sample_coroutine_android

import android.app.Activity
import android.app.Application
import com.sample_coroutine_android.di.DaggerMindevComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MinDevApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerMindevComponent.builder()
            .application(this)
            .build()
    }
}
