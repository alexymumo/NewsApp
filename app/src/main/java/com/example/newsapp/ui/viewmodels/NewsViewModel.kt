package com.example.newsapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.local.entities.Articles
import com.example.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(application: Application, private val newsRepository: NewsRepository) : AndroidViewModel(application) {

    fun saveArticle(articles: Articles) = viewModelScope.launch {
        newsRepository.saveArticle(articles)
    }

    fun deleteArticle(articles: Articles) = viewModelScope.launch {
        newsRepository.deleteArticle(articles)
    }

    fun fetchAllArticles(articles: Articles) = newsRepository.getAllArticles()
}
