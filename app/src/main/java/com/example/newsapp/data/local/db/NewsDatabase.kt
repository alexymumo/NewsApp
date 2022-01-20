package com.example.newsapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.data.local.dao.NewsDao
import com.example.newsapp.data.local.converter.Converters
import com.example.newsapp.data.local.entities.Articles

@Database(entities = [Articles::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsDatabase : RoomDatabase() {  
    abstract fun newsDao(): NewsDao
}