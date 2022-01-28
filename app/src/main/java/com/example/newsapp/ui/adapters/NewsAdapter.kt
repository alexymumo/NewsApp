package com.example.newsapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.local.entities.Articles
import com.example.newsapp.databinding.ItemViewBinding

class NewsAdapter constructor(private val articles: MutableList<Articles>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemViewBinding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articles = articles[position]
        holder.bind(holder.itemView.context, articles)

    }


    class NewsViewHolder(private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context?, articles: Articles) {
            Glide.with(context!!).load(articles.urlImage).into(binding.ivArticleImage)
            binding.tvDescription.text = articles.description
            binding.tvTitle.text = articles.title
            binding.tvSource.text = articles.author

        }

    }

}