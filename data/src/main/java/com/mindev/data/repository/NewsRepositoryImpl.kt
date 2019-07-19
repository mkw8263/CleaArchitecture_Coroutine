package com.mindev.data.repository

import com.mindev.data.MindevService
import com.mindev.data.entity.DataEntity
import kotlinx.coroutines.Deferred
import javax.inject.Inject

interface NewsRepository {
    fun getNewsAsync(id: Int): Deferred<List<DataEntity.NewsInfo>>
}

class NewsRepositoryImpl @Inject constructor(private val service: MindevService) :
    NewsRepository {
    override fun getNewsAsync(id: Int): Deferred<List<DataEntity.NewsInfo>> =
        service.getNewsAsync(id)
}
