package com.example.newsapp.ui.viewmodels


import androidx.lifecycle.*
import com.example.newsapp.data.local.entities.News
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.utils.StateListener


class NewsViewModel(private val newsRepository: NewsRepository): ViewModel() {

    private var stateListener: StateListener? = null
    private val _news = MutableLiveData<MutableList<News>>()
    val news: LiveData<MutableList<News>> = _news

    //val news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    //private val _news: MutableLiveData<Resource<NewsResponse>> = news

   val getAllNews = liveData {

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
    }

}



