package com.example.newsapp.dao

import androidx.room.Dao

@Dao
interface NewsDao {

    suspend fun getNews() {

    }
}