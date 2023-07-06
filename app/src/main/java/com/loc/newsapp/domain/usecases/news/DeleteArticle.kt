package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.data.local.NewsDao
import com.loc.newsapp.domain.model.Article

class DeleteArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }

}