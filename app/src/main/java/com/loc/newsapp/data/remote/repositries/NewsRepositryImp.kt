package com.loc.newsapp.data.remote.repositries

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.newsapp.data.remote.NewsApi
import com.loc.newsapp.data.remote.NewspagingSource
import com.loc.newsapp.domain.Repositries.NewsRepositry
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositryImp (
    private val NewsApi : NewsApi
): NewsRepositry {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewspagingSource(
                    NewsApi,sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}