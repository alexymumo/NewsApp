package com.example.newsapp.data.local.entities

import androidx.room.Entity
@Entity(tableName = "news_table")
data class News(
    val id: Int,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
