package com.loc.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.newsapp.data.database.NewsDao
import com.loc.newsapp.data.network.NewsAPI
import com.loc.newsapp.data.network.paging.NewsPagingSource
import com.loc.newsapp.data.network.paging.SearchNewsPagingSource
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsAPI,
    private val newsDao: NewsDao
) : NewsRepository {

    override fun getNewsFromRepository(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNewsFromRepository(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticleRepository(article: Article) {
        newsDao.upsertArticleToDatabase(article)
    }

    override suspend fun deleteArticleRepository(article: Article) {
        newsDao.deleteArticleFromDatabase(article)
    }

    override fun selectBookmarkArticlesRepository(): Flow<List<Article>> {
        return newsDao.getAllArticlesFromDatabase()
    }

    override suspend fun selectBookmarkArticleRepository(url: String): Article? {
        return newsDao.getSelectedArticleFromDatabase(url)
    }
}