package com.example.newsapp.data.network

import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.utils.Constants.Companion.API_KEY
import retrofit2.http.GET

interface NewsApi {
    @GET("?key=$API_KEY")
    suspend fun getAllNews(): NewsResponse
}