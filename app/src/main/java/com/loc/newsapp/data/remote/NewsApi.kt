package com.loc.newsapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

private val Base_Url = "https://newsapi.org/v2/everything?q=1&source=fd&apiKey=60983feaf40f49599a1086dc3d491358"
interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("q") q : Int,
        @Query("source") source : String,
        @Query("apiKey") apiKey : String
    ):NewsResponse
}