package com.mindev.presentation.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindev.domain.entity.DomainEntity

class NewsAdapter(private val items: List<DomainEntity.NewsInfo>) :
    RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(parent)

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(items[position])
}
