package com.example.newsapp.data.network

import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top_headlines")
    suspend fun getAllNews(
        @Query("api") api_key: String
    ) : Resource<NewsResponse>
}