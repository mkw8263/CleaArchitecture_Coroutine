//package com.sample_coroutine_android.di.module.main
//
//import com.mindev.data.MindevService
//import com.mindev.data.repository.DeliveryRepository
//import com.mindev.data.repository.DeliveryRepositoryImpl
//import com.mindev.domain.news.NewsUseCase
//import com.sample_coroutine_android.di.qualifier.PerActivity
//import dagger.Module
//import dagger.Provides
//import javax.inject.Named
//
//@Module
//class MainModule {
//    @PerActivity
//    @Provides
//    @Named("DeliveryUseCaseImpl")
//    fun provideDeliveryRepository(apiService: MindevService): DeliveryRepository =
//        DeliveryRepositoryImpl(apiService)
//
//    @PerActivity
//    @Provides
//    fun provideDeliveryUseCase(@Named("DeliveryUseCaseImpl") repo: DeliveryRepository): NewsUseCase =
//        NewsUseCase(repo)
//
//}
