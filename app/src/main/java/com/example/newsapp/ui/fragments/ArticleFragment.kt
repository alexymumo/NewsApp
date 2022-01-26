package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.newsapp.R
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var newsViewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnclickListener(View.OnClickListener {
            newsViewModel.saveArticle(articles)
            Snackbar.make(view, "saved", Snackbar.LENGTH_SHORT).show()
        })
    }
}