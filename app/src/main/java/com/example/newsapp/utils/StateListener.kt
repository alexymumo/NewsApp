package com.example.newsapp.utils

interface StateListener {

    fun onLoading()

    fun onSuccess(message:String)

    fun OnFailure(message: String)
}