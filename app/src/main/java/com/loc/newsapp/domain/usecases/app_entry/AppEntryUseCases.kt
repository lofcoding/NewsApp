package com.loc.newsapp.domain.usecases.app_entry

import com.loc.newsapp.domain.usecases.news.DeleteArticle
import com.loc.newsapp.domain.usecases.news.GetArticles
import com.loc.newsapp.domain.usecases.news.UpsertArticle

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry,
)