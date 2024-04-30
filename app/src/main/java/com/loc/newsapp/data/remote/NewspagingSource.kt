package com.loc.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.domain.model.Article

class NewspagingSource(
    private val NewsApi : NewsApi,
    private val source : String
): PagingSource<Int, Article>() {
    private var totalNewsCount = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val q = params.key ?: 1
        return try {
            val newsResponse = NewsApi.getNews(q = q , source = source, apiKey = "60983feaf40f49599a1086dc3d491358")
            totalNewsCount = newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title } // Remove duplicates
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else q+1,
                prevKey = null
                )
        }catch (e : Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}