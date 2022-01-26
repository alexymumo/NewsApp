package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.newsapp.R

@Suppress("DEPRECATION")
class SplashFragment : Fragment(R.layout.fragment_sports) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            findNavController().navigate(R.id.articleFragment)
        }, 2000)
    }
}