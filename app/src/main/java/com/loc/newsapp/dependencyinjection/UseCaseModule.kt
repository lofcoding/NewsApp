package com.loc.newsapp.dependencyinjection

import com.loc.newsapp.data.database.NewsDao
import com.loc.newsapp.domain.repository.NewsRepository
import com.loc.newsapp.domain.usecases.news.DeleteArticleDatabase
import com.loc.newsapp.domain.usecases.news.GetAllNews
import com.loc.newsapp.domain.usecases.news.NewsUseCase
import com.loc.newsapp.domain.usecases.news.GetSearchNews
import com.loc.newsapp.domain.usecases.news.SelectBookmarkArticleDatabase
import com.loc.newsapp.domain.usecases.news.SelectBookmarkAllArticleDatabase
import com.loc.newsapp.domain.usecases.news.UpsertArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCase {
        return NewsUseCase(
            getAllNews = GetAllNews(newsRepository),
            getSearchNews = GetSearchNews(newsRepository),
            upsertArticleDatabase = UpsertArticleDatabase(newsRepository),
            deleteArticleDatabase = DeleteArticleDatabase(newsRepository),
            selectBookmarkAllArticleDatabase = SelectBookmarkAllArticleDatabase(newsRepository),
            selectBookmarkArticleDatabase = SelectBookmarkArticleDatabase(newsRepository)
        )
    }

}