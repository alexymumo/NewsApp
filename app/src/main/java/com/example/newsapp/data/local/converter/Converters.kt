package com.example.newsapp.data.local.converter

import androidx.room.TypeConverter
import com.example.newsapp.data.local.entities.Sources

class Converters {
    @TypeConverter
    fun fromSource(sources: Sources):String{
        return sources.name
    }
    @TypeConverter
    fun toSource(name: String):Sources {
        return Sources(name, name)
    }
}