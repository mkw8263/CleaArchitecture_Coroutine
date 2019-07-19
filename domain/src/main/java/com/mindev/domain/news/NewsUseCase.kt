package com.mindev.domain.news

import com.common.Result
import com.mindev.data.repository.NewsRepository
import com.mindev.domain.BaseUseCase
import com.mindev.domain.entity.DomainEntity
import com.mindev.domain.mapper.NewsMapper
import java.io.IOException
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val repo: NewsRepository,
    private val newsMapper: NewsMapper
) : BaseUseCase<List<DomainEntity.NewsInfo>, NewsUseCase.Params> {

    override suspend fun execute(params: Params?): Result<Exception, List<DomainEntity.NewsInfo>> {
        return try {
            val request = repo.getNewsAsync(params?.id ?: 0)
            Result.Success(newsMapper.mapFromEntity(request.await()))
        } catch (e: Exception) {
            Result.Error(IOException("network error"))
        }
    }

    data class Params(val id: Int)
}

