package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsViewModel


class TrendingFragment : Fragment() {

    private val viewModels: NewsViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_trending, container, false)


    }
}