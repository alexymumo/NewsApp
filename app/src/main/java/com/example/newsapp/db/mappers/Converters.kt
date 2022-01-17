package com.example.newsapp.db.mappers

import androidx.room.TypeConverters
import com.example.newsapp.models.Sources

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