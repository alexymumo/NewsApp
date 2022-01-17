package com.example.newsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.dao.NewsDao

@Database(entities = [NewsDao::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    //private val newsDao: NewsDao()
}