package com.example.newsapp.data.repository

import com.example.newsapp.data.local.db.NewsDatabase
import com.example.newsapp.data.local.entities.Articles
import com.example.newsapp.data.network.NewsApi

class NewsRepository(private val newsDatabase: NewsDatabase) {
    suspend fun saveArticle(articles: Articles) = newsDatabase.newsDao().saveArticle(articles)

    suspend fun deleteArticle(articles: Articles) = newsDatabase.newsDao().deleteArticles(articles)

    fun getAllArticles() = newsDatabase.newsDao().fetchArticles()

}