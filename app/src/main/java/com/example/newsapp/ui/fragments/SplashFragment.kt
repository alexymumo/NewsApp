package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentSplashBinding

@Suppress("DEPRECATION")
class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_newsFragment)
        }, 2000)

        return binding.root
    }
}