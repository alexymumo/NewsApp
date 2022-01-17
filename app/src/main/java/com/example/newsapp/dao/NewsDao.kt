package com.example.newsapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.models.Articles

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveArticle(articles: Articles)

    @Query("SELECT * FROM article_table")
    fun fetchArticles(): LiveData<List<Articles>>

    @Delete
    suspend fun deleteArticles(articles: Articles)
}