package com.example.newsapp.data.local.entities

data class NewsResponse(
    val articles: MutableList<Articles>,
    val status: String?,
    val totalResults: Int
)
