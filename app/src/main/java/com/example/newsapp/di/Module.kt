package com.example.newsapp.di

import androidx.room.Room
import com.example.newsapp.data.local.db.NewsDatabase
import com.example.newsapp.data.network.NewsApi
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule : Module = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            NewsDatabase::class.java,
            "news-db"
        ).build()
    }
}

val networkingModule : Module = module {
    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttp())
            .build()
            .create(NewsApi::class.java)

    }
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}

fun provideOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

val repositoryModule : Module = module {
    single { NewsRepository(get(), get()) }
}

val daoModule : Module = module {
    single { get<NewsDatabase>().newsDao() }
}

val viewModelModule : Module = module {
    viewModel { NewsViewModel(get()) }
}

val appModules : List<Module> = listOf(
    databaseModule,
    networkingModule,
    repositoryModule,
    databaseModule,
    viewModelModule,
    daoModule,
)