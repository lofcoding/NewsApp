package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.data.local.NewsDao
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}