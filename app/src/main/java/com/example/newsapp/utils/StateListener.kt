package com.example.newsapp.utils

interface StateListener {

    fun onLoading()

    fun onSuccess(message:String)

    fun onFailure(message: String)
}