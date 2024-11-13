package com.loc.newsapp.data.network

import com.loc.newsapp.BuildConfig
import com.loc.newsapp.data.network.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): NewsResponse

}