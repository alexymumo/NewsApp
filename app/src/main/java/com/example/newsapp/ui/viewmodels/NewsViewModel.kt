package com.example.newsapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.utils.Resource

import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository,application: Application) : AndroidViewModel(application) {

    val news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val _news: MutableLiveData<Resource<NewsResponse>> = news

    init {
        getAllNews()
    }

    private fun getAllNews(){
        viewModelScope.launch {
            _news.postValue(Resource.Loading())
            val response = newsRepository.getAllNews()
            _news.postValue(handleNewsResponse(response))
        }
    }
}

// news response
private fun handleNewsResponse(response: retrofit2.Response<NewsResponse>): Resource<NewsResponse> {
    if (response.isSuccessful) {
        response.body()?.let { newsResponse ->
            return Resource.Success(newsResponse)
        }
    }
    return Resource.Error(response.message())
}



