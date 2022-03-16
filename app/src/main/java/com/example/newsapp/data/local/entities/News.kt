package com.example.newsapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "news_table")
data class News(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val source: Source,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
): Serializable
