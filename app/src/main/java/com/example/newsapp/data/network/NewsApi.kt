package com.example.newsapp.data.network

import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.utils.Constants.Companion.API_KEY
import com.example.newsapp.utils.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET(ENDPOINT)
    suspend fun getTechNews(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String,
        @Query("category") categoryString: String = "tech"
    ) : Response<NewsResponse>

    @GET(ENDPOINT)
    suspend fun getBreakingNews(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String,
        @Query("category") categoryString: String = "breaking"
    ) : Response<NewsResponse>

    @GET(ENDPOINT)
    suspend fun getSportsNews(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String,
        @Query("category") categoryString: String = "sports"
    ) : Response<NewsResponse>

    @GET(ENDPOINT)
    suspend fun getTrendingNews(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String,
        @Query("category") categoryString: String = "trending"
    ) : Response<NewsResponse>
}