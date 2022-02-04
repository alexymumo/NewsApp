package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.ui.viewmodels.NewsViewModel

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

    }

    private fun initUI() {
        viewModel.news.observe(viewLifecycleOwner, { news ->
           // Glide.with(requireActivity()).load().into(binding.ivArticleImage)

            binding.tvDescription.text
            binding.tvTitle.text
            binding.tvPublishedAt.text


        })

    }
}