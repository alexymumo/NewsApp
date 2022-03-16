package com.example.newsapp.ui.viewmodels

import androidx.lifecycle.*
import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {
    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1
    var breakingNewsResponse : NewsResponse? = null

    private val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1
    var searchNewsResponse: NewsResponse? = null

    init {
        getbreakingNews("us")
    }
    fun searchNews(searchQuery : String) = viewModelScope.launch{
        searchNews.postValue(Resource.Loading())
        val response = newsRepository.searchNews(searchQuery,searchNewsPage)
        searchNews.postValue(handleSearchNewsResponse(response))
    }

    fun getbreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }



    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                breakingNews++
                if (breakingNewsResponse == null) {
                    breakingNewsResponse = resultResponse
                } else {
                    val oldNews = breakingNewsResponse?.articles
                    val newNews = resultResponse.articles
                    oldNews?.addAll(newNews)
                }
                return Resource.Success(breakingNewsResponse?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
    private fun  handleSearchNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse>{
        if(response.isSuccessful){
            response.body()?.let {resultResponse ->
                searchNewsPage++
                if (searchNewsResponse == null){
                    searchNewsResponse = resultResponse
                }else{
                    val oldArticles = searchNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(searchNewsResponse?: resultResponse)
            }
        }
        return  Resource.Error(response.message())
    }
}



