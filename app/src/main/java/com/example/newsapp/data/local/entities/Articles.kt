package com.example.newsapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "article_table")
data class Articles(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: Sources?,
    val title: String?,
    val url: String?,
    val urlImage: String?
) : Serializable
