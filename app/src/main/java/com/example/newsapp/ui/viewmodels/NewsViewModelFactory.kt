package com.example.newsapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.data.repository.NewsRepository
import java.lang.IllegalArgumentException

class NewsViewModelFactory(val application: Application,val newsRepository: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)){
            @Suppress("UNCHECKED CAST")
            return NewsViewModel(application,newsRepository)  as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}