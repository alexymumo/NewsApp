package com.example.newsapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.local.entities.News
import com.example.newsapp.databinding.ItemViewBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val news: List<News> = TODO()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemViewBinding = ItemViewBinding.inflate(
            layoutInflater, parent, false
        )
        return NewsViewHolder(binding)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = news[position]
        holder.bind(holder.itemView.context, news)
    }

    class NewsViewHolder(private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context?, news: News) {
            Glide.with(context!!).load(news.urlImage).into(binding.ivArticleImage)
            binding.tvDescription.text = news.description
        }

    }

}