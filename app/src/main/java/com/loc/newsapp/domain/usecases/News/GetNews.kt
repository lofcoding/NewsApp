package com.loc.newsapp.domain.usecases.News

import androidx.paging.PagingData
import com.loc.newsapp.domain.Repositries.NewsRepositry
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val NewsRepositry : NewsRepositry
) {
    operator fun invoke(sources : List<String>) : Flow<PagingData<Article>> {
        return NewsRepositry.getNews(sources = sources)
    }
}