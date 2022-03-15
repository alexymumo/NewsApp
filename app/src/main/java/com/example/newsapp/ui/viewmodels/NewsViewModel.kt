package com.example.newsapp.ui.viewmodels


import androidx.lifecycle.*
import com.example.newsapp.data.local.entities.News
import com.example.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    private val _news = MutableLiveData<MutableList<News>>()
    val news: LiveData<MutableList<News>> = _news

    fun fetchNews() = viewModelScope.launch {

    }
}



