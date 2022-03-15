package com.example.newsapp.data.repository

import com.example.newsapp.data.local.db.NewsDatabase
import com.example.newsapp.data.network.NewsApi
import javax.inject.Inject


class NewsRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val newsDatabase: NewsDatabase): BaseRepository() {



}