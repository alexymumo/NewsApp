package com.example.newsapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.local.entities.Articles
import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.launch
import okhttp3.Response


class NewsViewModel(application: Application, private val newsRepository: NewsRepository) : AndroidViewModel(application) {

    var sportsNewsPage = 1
    val sportsNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var sportsNewsResponse: NewsResponse? = null

    var trendingNewsPage = 1
    val trendingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var trendingNewsResponse: NewsResponse? = null

    var techNewsPage = 1
    val techNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var techNewsResponse: NewsResponse? = null



    init {
        getTechNews("us")
        getTrendingNews("us")
        getSportsNews("us")
    }

    fun getSportsNews(countryCode: String) = viewModelScope.launch {
        sportsNewsCall(countryCode)
    }

    fun getTrendingNews(countryCode: String) = viewModelScope.launch {
        trendingNewsCall(countryCode)
    }

    fun getTechNews(countryCode: String) = viewModelScope.launch {
        techNewsCall(countryCode)
    }

    private suspend fun sportsNewsCall(countryCode: String) {
        sportsNews.postValue(Resource.Loading())
        val response = newsRepository.getSportsNews(countryCode,sportsNewsPage)
        sportsNews.postValue(sportsNewsResponse(response))
    }

    private suspend fun trendingNewsCall(countryCode: String) {
        trendingNews.postValue(Resource.Loading())
        val response = newsRepository.getTrendingNews(countryCode,trendingNewsPage)
        trendingNews.postValue(trendingNewsResponse(response))
    }

    private suspend fun techNewsCall(countryCode: String) {
        techNews.postValue(Resource.Loading())
        val response = newsRepository.getTechNews(countryCode, techNewsPage)
        techNews.postValue(techNewsResponse(response))

    }

    private fun techNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>? {
        if (response.isSuccessful){
            response.body()?.let { newsResponse ->
                techNewsPage++
                if (techNewsResponse == null){
                    techNewsResponse = newsResponse
                }else{
                    val oldArticles =techNewsResponse?.articles
                    val newArticles = newsResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return@let Resource.Success(techNewsResponse ?: newsResponse)
            }
        }
        return Resource.Error(response.message(), null)
    }


    private fun trendingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>? {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                trendingNewsPage++
                if (techNewsResponse == null){
                    techNewsResponse = techNewsResponse
                }else {
                    val oldArticles = trendingNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)

                }
                return@let Resource.Success(trendingNewsResponse ?: resultResponse)

            }
        }
        return Resource.Error(response.message(), null)

    }

    private fun sportsNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>? {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                sportsNewsPage++
                if (sportsNewsResponse == null){
                    sportsNewsResponse = sportsNewsResponse
                }else {
                    val oldArticles = sportsNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)

                }
                return@let Resource.Success(sportsNewsResponse ?: resultResponse)

            }
        }
        return Resource.Error(response.message(), null)

    }

    fun saveArticle(articles: Articles) = viewModelScope.launch {
        newsRepository.saveArticle(articles)
    }

    fun deleteArticle(articles: Articles) = viewModelScope.launch {
        newsRepository.deleteArticle(articles)
    }

    fun fetchAllArticles(articles: Articles) = newsRepository.getAllArticles()
}
