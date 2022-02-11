package com.example.newsapp.ui.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.utils.StateListener
import kotlinx.coroutines.launch


class NewsFragment : Fragment(R.layout.fragment_news), StateListener {
    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModels()

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        val view = binding.root
        initUI()
        initNewsRecyclerView()

        return view
        //return binding.root
    }

    private fun initNewsRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initUI() {
        viewModel.news.observe(this, Observer {
            viewModel.getAllNews.value
        })

    }

    override fun onLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onSuccess(message: String) {
        binding.progressBar.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        binding.progressBar.visibility = View.VISIBLE
        Toast.makeText(requireContext(), "Network error", Toast.LENGTH_SHORT).show()
    }
}
