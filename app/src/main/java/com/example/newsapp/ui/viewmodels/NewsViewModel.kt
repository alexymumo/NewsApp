package com.example.newsapp.ui.viewmodels


import androidx.lifecycle.*
import com.example.newsapp.data.local.entities.News
import com.example.newsapp.data.local.entities.NewsResponse
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository): ViewModel() {

    private val _newResponse: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val newsResponse: LiveData<Resource<NewsResponse>>
    get() = _newResponse

    private val _news = MutableLiveData<MutableList<News>>()
    val news: LiveData<MutableList<News>> = _news

    //val news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    //private val _news: MutableLiveData<Resource<NewsResponse>> = news

    fun fetchNews(key: String) = viewModelScope.launch {
        _newResponse.value = newsRepository.getAllNews(key)

    }

   /*val getAllNews = liveData {

        stateListener?.onLoading()
        try {
            val news = newsRepository.getAllNews()
            news.let { news ->
                stateListener?.onSuccess("News fetched")
                emit(news)
            }

        }catch (e: Exception){
            stateListener?.onFailure(e.message.toString())
        }
    }*/

}



