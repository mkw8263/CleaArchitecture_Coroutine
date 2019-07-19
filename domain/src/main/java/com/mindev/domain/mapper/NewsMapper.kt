package com.mindev.domain.mapper

import com.mindev.data.entity.DataEntity
import com.mindev.domain.entity.DomainEntity
import javax.inject.Inject

class NewsMapper @Inject constructor() :
    Mapper<List<DataEntity.NewsInfo>, List<DomainEntity.NewsInfo>> {
    override fun mapFromEntity(type: List<DataEntity.NewsInfo>): List<DomainEntity.NewsInfo> {
        return type.map {
            with(it) {
                DomainEntity.NewsInfo(
                    comments_count,
                    domain,
                    id,
                    points,
                    time,
                    time_ago,
                    title,
                    it.type,
                    url,
                    user
                )
            }
        }
    }

    override fun mapToEntity(type: List<DomainEntity.NewsInfo>): List<DataEntity.NewsInfo> {
        return type.map {
            with(it) {
                DataEntity.NewsInfo(
                    comments_count,
                    domain,
                    id,
                    points,
                    time,
                    time_ago,
                    title,
                    it.type,
                    url,
                    user
                )
            }
        }
    }
}
