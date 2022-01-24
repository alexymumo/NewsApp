package com.example.newsapp.data.repository

import com.example.newsapp.data.local.db.NewsDatabase
import com.example.newsapp.data.local.entities.Articles
import com.example.newsapp.data.network.NewsApi

class NewsRepository(private val newsDatabase: NewsDatabase, private val newsApi: NewsApi) {

    /*suspend fun getTechNews(countryCode: String, pageNo: Int) =
        newsApi.getTechNews(countryCode, pageNo)

    suspend fun getBreakingNews(countryCode: String, pageNo: Int) =
        newsApi.getBreakingNews(countryCode, pageNo)

    suspend fun getSportsNews(countryCode: String, pageNo: Int) =
        newsApi.getSportsNews(countryCode, pageNo)

    suspend fun getTrendingNews(countryCode: String, pageNo: Int) =
        newsApi.getTrendingNews(countryCode, pageNo)

     */
    suspend fun saveArticle(articles: Articles) = newsDatabase.newsDao().saveArticle(articles)

    suspend fun deleteArticle(articles: Articles) = newsDatabase.newsDao().deleteArticles(articles)

    fun getAllArticles() = newsDatabase.newsDao().fetchArticles()

}