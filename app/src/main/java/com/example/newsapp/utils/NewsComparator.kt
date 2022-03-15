package com.example.newsapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.data.local.entities.News

class NewsComparator: DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }
}