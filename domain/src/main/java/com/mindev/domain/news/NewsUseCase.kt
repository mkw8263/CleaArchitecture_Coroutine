package com.mindev.domain.news

import com.mindev.data.repository.NewsRepository
import com.mindev.domain.BaseUseCase
import com.mindev.domain.entity.DomainEntity
import com.mindev.domain.mapper.NewsMapper
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val repo: NewsRepository,
    private val newsMapper: NewsMapper
) : BaseUseCase<List<DomainEntity.NewsInfo>, NewsUseCase.Params> {

    override suspend fun execute(params: Params?): List<DomainEntity.NewsInfo> {
        val request = repo.getNewsAsync(params?.id ?: 0)
        return newsMapper.mapFromEntity(request.await())
    }

    data class Params(val id: Int)
}

