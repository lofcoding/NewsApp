package com.loc.newsapp.domain.usecases.news

data class NewsUseCase(
    val getAllNews: GetAllNews,
    val getSearchNews: GetSearchNews,
    val upsertArticleDatabase: UpsertArticleDatabase,
    val deleteArticleDatabase: DeleteArticleDatabase,
    val selectBookmarkAllArticleDatabase: SelectBookmarkAllArticleDatabase,
    val selectBookmarkArticleDatabase: SelectBookmarkArticleDatabase
)
