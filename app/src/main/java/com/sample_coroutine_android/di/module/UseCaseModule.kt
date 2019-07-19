package com.sample_coroutine_android.di.module

import com.mindev.data.repository.NewsRepository
import com.mindev.domain.mapper.NewsMapper
import com.mindev.domain.news.NewsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideDeliveryUseCase(repo: NewsRepository, newsMapper: NewsMapper): NewsUseCase =
        NewsUseCase(repo, newsMapper)
}
