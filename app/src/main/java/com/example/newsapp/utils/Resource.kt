package com.example.newsapp.utils

sealed class Resource<T>(
    val data: Any? = null,
    val message:String?=null
){
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String?): Resource<T>(message)
    class Loading<T>:Resource<T>()
}
