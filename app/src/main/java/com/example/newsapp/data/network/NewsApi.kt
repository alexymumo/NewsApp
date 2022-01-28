package com.example.newsapp.data.network

import com.example.newsapp.data.local.entities.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    /*@GET(ENDPOINT)
    suspend fun getTechNews(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String = "us",
        @Query("category") categoryString: String = "tech"
    ) : Response<NewsResponse>

    @GET(ENDPOINT)
    suspend fun getBreakingNews(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String = "us",
        @Query("category") categoryString: String = "breaking"
    ) : Response<NewsResponse>

    @GET(ENDPOINT)
    suspend fun getSportsNews(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String = "us",
        @Query("category") categoryString: String = "sports"
    ) : Response<NewsResponse>

     */

    @GET("v2/top_headlines")
    suspend fun getAllNews() : Response<NewsResponse>

    /*
    @GET(ENDPOINT)
    suspend fun getTrendingNews(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String = "us",
        @Query("category") categoryString: String = "trending"
    ) : Response<NewsResponse>


     */
}