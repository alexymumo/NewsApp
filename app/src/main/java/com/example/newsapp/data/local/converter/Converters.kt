package com.example.newsapp.data.local.converter

import androidx.room.TypeConverters
import com.example.newsapp.data.local.entities.Sources

class Converters {
    @TypeConverters
    fun fromSource(sources: Sources): String {
        return sources.name
    }
    @TypeConverters
    fun toSource(name: String): Sources {
        return Sources(name, name)
    }
}