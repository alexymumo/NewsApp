package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.ui.viewmodels.NewsViewModel
import java.util.*

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        newsViewModel.getAllNews(viewLifecycleOwner) { news ->
            //Glide.with(requireActivity()).load(news)
            binding

        }
    }
}