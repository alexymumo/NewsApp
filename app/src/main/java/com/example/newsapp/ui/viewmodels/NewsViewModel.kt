package com.example.newsapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.local.entities.Articles
import com.example.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(application: Application, private val newsRepository: NewsRepository) : AndroidViewModel(application) {

    var breakingNewsPage = 1

    init {
        getBreakingNews()
        getTechNews()
        getTrendingNews()
        getSportsNews()
    }

    private fun getSportsNews() {
        TODO("Not yet implemented")
    }

    private fun getTrendingNews() {
        TODO("Not yet implemented")
    }

    private fun getTechNews() {
        TODO("Not yet implemented")
    }

    private fun getBreakingNews() {
        TODO("Not yet implemented")
    }

    fun saveArticle(articles: Articles) = viewModelScope.launch {
        newsRepository.saveArticle(articles)
    }

    fun deleteArticle(articles: Articles) = viewModelScope.launch {
        newsRepository.deleteArticle(articles)
    }

    fun fetchAllArticles(articles: Articles) = newsRepository.getAllArticles()
}
