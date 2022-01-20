package com.example.newsapp

import android.app.Application
import com.example.newsapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@NewsApplication)
            val modules = mutableListOf<Module>().apply {
                addAll(appModules)
            }
            modules(modules)
        }
    }
}