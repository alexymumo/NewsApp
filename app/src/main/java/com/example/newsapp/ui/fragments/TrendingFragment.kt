package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.example.newsapp.R
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.utils.Resource


class TrendingFragment : Fragment(R.layout.fragment_trending) {
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        setUpRecyclerView()
    }

    private fun initUI() {
        newsViewModel.trendingNews.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Error -> {

                }
            }
        })
    }

    private fun setUpRecyclerView() {
        newsAdapter = NewsAdapter()


    }

}