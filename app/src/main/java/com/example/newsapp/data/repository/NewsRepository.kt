package com.example.newsapp.data.repository

import com.example.newsapp.data.local.db.NewsDatabase
import com.example.newsapp.data.local.entities.News
import com.example.newsapp.data.network.NewsApi

class NewsRepository(private val newsDatabase: NewsDatabase, private val newsApi: NewsApi) {

    /*suspend fun getTechNews(countryCode: String, pageNumber: Int) =
        newsApi.getTechNews(countryCode, pageNumber)

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        newsApi.getBreakingNews(countryCode, pageNumber)

    suspend fun getSportsNews(countryCode: String, pageNumber: Int) =
        newsApi.getSportsNews(countryCode, pageNumber)

    suspend fun getTrendingNews(countryCode: String, pageNumber: Int) =
        newsApi.getTrendingNews(countryCode, pageNumber)
    */
    suspend fun getAllNews() = newsApi.getAllNews()

    suspend fun saveArticle(news: News) =
        newsDatabase.newsDao().saveArticle(news)


    suspend fun deleteArticle(news: News) =
        newsDatabase.newsDao().deleteArticles(news)

    fun getAllArticles() =
        newsDatabase.newsDao().fetchArticles()

}