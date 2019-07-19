package com.mindev.presentation.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindev.domain.entity.DomainEntity
import com.mindev.presentation.R
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
) {

    fun bind(news: DomainEntity.NewsInfo) {
        with(itemView) {
            tv_user.text = news.user
            tv_time.text = news.time_ago
            tv_title.text = news.title
        }
    }
}
