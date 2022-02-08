package com.example.newsapp.data.network

import com.example.newsapp.data.local.entities.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("v2/top_headlines")
    suspend fun getAllNews() : Response<NewsResponse>

}