package com.example.newsapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.data.local.entities.News

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveArticle(news: News): Long

    @Query("SELECT * FROM news_table")
    fun fetchArticles(): LiveData<List<News>>

    @Delete
    suspend fun deleteArticles(news: News)

    @Query("SELECT *FROM news_table")
    fun getAllNews(): LiveData<List<News>>

}