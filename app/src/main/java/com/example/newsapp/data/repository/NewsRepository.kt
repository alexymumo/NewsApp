package com.example.newsapp.data.repository

import com.example.newsapp.data.local.db.NewsDatabase
import com.example.newsapp.data.network.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val newsDatabase: NewsDatabase) {

    suspend fun searchNews(searchQuery: String, pageNumber: Int) {
        newsApi.searchNews(searchQuery, pageNumber)
    }

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) {
        newsApi.getBreakingNews(countryCode, pageNumber)
    }
    suspend fun getTechNews(countryCode: String, pageNumber: Int) {
        newsApi.getTechNews(countryCode, pageNumber)
    }

}