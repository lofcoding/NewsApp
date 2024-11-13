package com.loc.newsapp.domain.repository

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNewsFromRepository(sources: List<String>): Flow<PagingData<Article>>

    fun searchNewsFromRepository(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>

    suspend fun upsertArticleRepository(article: Article)

    suspend fun deleteArticleRepository(article: Article)

    fun selectBookmarkArticlesRepository(): Flow<List<Article>>

    suspend fun selectBookmarkArticleRepository(url: String): Article?

}