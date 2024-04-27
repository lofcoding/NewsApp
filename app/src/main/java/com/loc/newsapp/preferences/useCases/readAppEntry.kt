package com.loc.newsapp.preferences.useCases


import com.loc.newsapp.preferences.localUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager : localUserManager
) {
    suspend operator fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}