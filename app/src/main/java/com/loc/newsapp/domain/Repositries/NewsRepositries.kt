package com.loc.newsapp.domain.Repositries

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepositry {
    fun getNews(sources : List<String>) : Flow<PagingData<Article>>
}