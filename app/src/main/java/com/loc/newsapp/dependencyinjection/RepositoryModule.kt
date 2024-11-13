package com.loc.newsapp.dependencyinjection

import com.loc.newsapp.data.database.NewsDao
import com.loc.newsapp.data.network.NewsAPI
import com.loc.newsapp.data.repository.NewsRepositoryImpl
import com.loc.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsAPI,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi,newsDao)
}