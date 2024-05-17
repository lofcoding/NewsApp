package com.loc.newsapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertArticleToDatabase(article: Article)

    @Delete
    suspend fun deleteArticleFromDatabase(article: Article)

    @Query("SELECT * FROM Article")
    fun getAllArticlesFromDatabase(): Flow<List<Article>>

    @Query("SELECT * FROM Article WHERE url=:url")
    suspend fun getSelectedArticleFromDatabase(url: String): Article?
}