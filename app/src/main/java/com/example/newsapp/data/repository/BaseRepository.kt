package com.example.newsapp.data.repository

import com.example.newsapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

open class BaseRepository {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when(throwable) {
                    is HttpException -> {
                        Resource.Error(throwable.response()?.errorBody().toString())
                    }
                    else -> {
                        Resource.Error(throwable.localizedMessage)
                    }
                }
            }
        }
    }
}