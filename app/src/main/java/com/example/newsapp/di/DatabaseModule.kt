package com.example.newsapp.di

import android.content.Context
import androidx.room.Room
import com.example.newsapp.data.local.dao.NewsDao
import com.example.newsapp.data.local.db.NewsDatabase
import com.example.newsapp.data.network.NewsApi
import com.example.newsapp.data.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): NewsDatabase =
        Room.databaseBuilder(context, NewsDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDao(newsDatabase: NewsDatabase): NewsDao =
        newsDatabase.newsDao()


    @Provides
    @Singleton
    fun provideRepository(newsApi: NewsApi): NewsRepository{
        return NewsRepository(newsApi)
    }
}