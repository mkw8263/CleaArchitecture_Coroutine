package com.sample_coroutine_android.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mindev.data.MindevService
import com.sample_coroutine_android.BuildConfig
import com.sample_coroutine_android.R
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetWorkModule {

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            chain.proceed(request.newBuilder().build())
        }
    }

    @Provides
    @Singleton
    fun createClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            if (BuildConfig.DEBUG) addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BODY
                )
            )
            connectTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            addInterceptor(interceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun provideApiService(
        context: Context,
        okHttpClient: OkHttpClient,
        gson: Gson
    ): MindevService {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(MindevService::class.java)
    }

    companion object {
        const val HEADER_AUTH_PARAM = "Authorization"
        const val NETWORK_TIME_OUT: Long = 15
    }
}
