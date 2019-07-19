package com.mindev.domain.entity


sealed class DomainEntity {
    data class NewsInfo(
        val comments_count: Int? = 0,
        val domain: String? = "",
        val id: Int? = 0,
        val points: Int? = 0,
        val time: Int? = 0,
        val time_ago: String? = "",
        val title: String? = "",
        val type: String? = "",
        val url: String? = "",
        val user: String? = ""
    ) : DomainEntity()
}
