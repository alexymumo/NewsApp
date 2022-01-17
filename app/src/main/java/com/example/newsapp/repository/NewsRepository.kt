package com.example.newsapp.repository

import com.example.newsapp.dao.NewsDao
import com.example.newsapp.db.NewsDatabase
import com.example.newsapp.models.Articles

class NewsRepository(val newsDatabase: NewsDatabase) {

    suspend fun saveArticle(articles: Articles) = newsDatabase.newsDao().saveArticle(articles)

    suspend fun deleteArticle(articles: Articles) = newsDatabase.newsDao().deleteArticles(articles)

    fun getAllArticles() = newsDatabase.newsDao().fetchArticles()


}