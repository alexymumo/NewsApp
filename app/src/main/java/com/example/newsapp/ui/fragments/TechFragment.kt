package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.example.newsapp.R
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.utils.Resource

class TechFragment : Fragment(R.layout.fragment_tech) {
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel.techNews.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {

                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        })
    }
}