package com.example.newsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    val news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val _news : MutableLiveData<Resource<NewsResponse>> = news

    fun getAllNews(){
        viewModelScope.launch {
            _news.postValue(Resource.Loading())
            val response = newsRepository.getAllNews()
            _news.postValue(handleNewsResponse(response))
        }
    }
    }

    private fun handleNewsResponse(response: retrofit2.Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { newsResponse ->
                return@let Resource.Success(newsResponse)
            }
        }
        return Resource.Error(response.message())
    }



