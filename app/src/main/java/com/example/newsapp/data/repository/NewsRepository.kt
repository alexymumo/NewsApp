package com.example.newsapp.data.repository

import com.example.newsapp.data.network.NewsApi


class NewsRepository(private val newsApi: NewsApi) {

    suspend fun getAllNews()  = newsApi.getAllNews()

}