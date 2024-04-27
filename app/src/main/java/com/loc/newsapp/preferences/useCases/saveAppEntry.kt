package com.loc.newsapp.preferences.useCases



import com.loc.newsapp.preferences.localUserManager

class SaveAppEntry(
    private val localUserManager : localUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}