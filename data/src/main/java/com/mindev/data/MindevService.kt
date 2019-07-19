package com.mindev.data

import com.mindev.data.entity.DataEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MindevService {

    @GET("/news")
    fun getNewsAsync(@Query("page") page: Int): Deferred<List<DataEntity.NewsInfo>>

}
