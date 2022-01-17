package com.example.newsapp.models

data class Response(
    val articles: MutableList<Articles>,
    val status: String?,
    val totalResults: Int
)
