package com.example.newsapp.ui.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.utils.Constants.Companion.QUERY_PAGE_SIZE
import com.example.newsapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {
    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.submitList(newsResponse.articles.toList())
                        val totalPages = newsResponse.totalResults / QUERY_PAGE_SIZE + 2
                        //isLastPage = viewModel.breakingNewsPage == totalPages

                    }


                }
                is Resource.Error -> {
                    hideProgressBar()
                }
                is Resource.Loading -> {
                    showProgressBar()

                }
            }
        })
        return binding.root
    }
    private fun showProgressBar() {
        binding.progressBar.isVisible = true
    }
    private fun hideProgressBar() {
        binding.progressBar.isVisible = true
    }
}
