package com.loc.newsapp.preferences.Repositries

import android.content.Context
import com.loc.newsapp.preferences.data.AppEntry
import kotlinx.coroutines.flow.Flow

interface AppEntryRepo{
    suspend  fun saveAppEntry()
    fun readAppEntry() : Flow<Boolean>
}
class localUserManager(private val context: Context) : AppEntryRepo{
    override suspend fun saveAppEntry() {
        AppEntry().saveAppEntry(context)
    }

    override fun readAppEntry(): Flow<Boolean> {
       return AppEntry().readAppEntry(context)
    }
}