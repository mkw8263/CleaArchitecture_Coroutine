package com.sample_coroutine_android.di.module

import com.mindev.data.MindevService
import com.mindev.data.repository.NewsRepository
import com.mindev.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {


    @Provides
    fun provideDeliveryRepository(apiService: MindevService): NewsRepository =
        NewsRepositoryImpl(apiService)
}
