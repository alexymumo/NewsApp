package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.utils.Resource

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
   // private val viewModel: NewsViewModel by activityViewModels()
    //private val viewModel by viewModels<NewsViewModel>()
    private lateinit var newsAdapter: NewsAdapter
    //private val args: NewsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        //initUI()
        //initNewsRecyclerView()
        return binding.root
    }

   /* private fun initNewsRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }


    private fun initUI() {
        viewModel.news.observe(viewLifecycleOwner, { result->
            when(result) {
                is Resource.Success -> {
                    hideProgressBar()
                    result.data.let {
                        binding.progressBar.visibility = View.GONE
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


    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE

    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }*/
}