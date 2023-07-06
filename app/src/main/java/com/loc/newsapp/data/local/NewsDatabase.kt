package com.loc.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.loc.newsapp.domain.model.Article

@Database(entities = [Article::class],version = 1,)
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao: NewsDao

}