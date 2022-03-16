package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.local.entities.News
import com.example.newsapp.databinding.ItemViewBinding
import com.example.newsapp.utils.NewsComparator

class NewsAdapter: ListAdapter<News,NewsAdapter.NewsViewHolder>(NewsComparator()) {

    inner class NewsViewHolder(private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            Glide.with(binding.ivArticleImage)
                .load(news.urlToImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivArticleImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.itemView.setOnClickListener {

        }
        holder.bind(news)
    }

    override fun getItemCount() = currentList.size
}