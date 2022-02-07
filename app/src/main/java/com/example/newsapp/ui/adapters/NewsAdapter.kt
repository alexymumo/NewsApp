package com.example.newsapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.local.entities.News
import com.example.newsapp.databinding.ItemViewBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    //private lateinit var articles: MutableList<Articles>

    val differCallBack = object : DiffUtil.ItemCallback<News>() {
        override fun areContentsTheSame(oldItem: News, newItem: News) =
            oldItem ==  oldItem

        override fun areItemsTheSame(oldItem: News, newItem: News) =
            oldItem.id == newItem.id
    }

    val differ = AsyncListDiffer(this, differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemViewBinding = ItemViewBinding.inflate(
            layoutInflater, parent, false
        )
        return NewsViewHolder(binding)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articles = differ.currentList[position]
        holder.bind(holder.itemView.context, articles)
    }

    class NewsViewHolder(private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context?, news: News) {
            Glide.with(context!!).load(news.urlImage).into(binding.ivArticleImage)
            binding.tvDescription.text = news.description
        }

    }

}