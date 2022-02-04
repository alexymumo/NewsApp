package com.example.newsapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

   /* var sportsNewsPage = 1
    val sportsNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var sportsNewsResponse: NewsResponse? = null

    var trendingNewsPage = 1
    val trendingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var trendingNewsResponse: NewsResponse? = null

    var techNewsPage = 1
    val techNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var techNewsResponse: NewsResponse? = null

*/

    private val news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private val _news : MutableLiveData<Resource<NewsResponse>> = news


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


    /*fun getAllNews(viewLifecycleOwner) {
        viewModelScope.launch {
            _news.postValue(Resource.Loading())
            val response = newsRepository.getAllNews()
            _news.postValue(handleNewsResponse(response))

        }

    }*/

    private fun handleNewsResponse(response: retrofit2.Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { newsResponse ->
                return@let Resource.Success(newsResponse)
            }
        }
        return Resource.Error(response.message())
    }

   /* fun saveArticle(articles: Articles) = viewModelScope.launch {
        newsRepository.saveArticle(articles)
    }

    fun deleteArticle(articles: Articles) = viewModelScope.launch {
        newsRepository.deleteArticle(articles)
    }

    fun fetchAllArticles(articles: Articles) = newsRepository.getAllArticles()
}

    */
