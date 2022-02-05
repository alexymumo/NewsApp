package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.utils.Resource

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initNewsRecyclerView()
    }

    private fun initNewsRecyclerView() {
        //newsAdapter = NewsAdapter(articles = MutableList<Articles>)

    }

    private fun initUI() {
        viewModel.news.observe(viewLifecycleOwner, { result->
            when(result) {
                is Resource.Success -> {
                    hideProgressBar()
                    result.data.let {
                    }
                }
                is Resource.Loading -> {
                    hideProgressBar()

                }
                is Resource.Error -> {
                    showProgressBar()

                }
            }

        })

    }

    private fun showProgressBar() {

        TODO("Not yet implemented")
    }

    private fun hideProgressBar() {
        TODO("Not yet implemented")
    }
}