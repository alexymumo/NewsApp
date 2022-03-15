package com.example.newsapp.data.local.entities

data class NewsResponse(
    val articles: MutableList<News>,
    val status: String,
    val totalResults: Int
)
