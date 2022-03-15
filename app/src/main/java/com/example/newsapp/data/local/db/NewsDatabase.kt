package com.example.newsapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.data.local.dao.NewsDao
import com.example.newsapp.data.local.entities.News

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {  
    abstract fun newsDao(): NewsDao
}