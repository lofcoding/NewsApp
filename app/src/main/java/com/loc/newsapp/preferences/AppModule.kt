package com.loc.newsapp.preferences

import android.app.Application
import com.loc.newsapp.preferences.useCases.Cases
import com.loc.newsapp.preferences.useCases.ReadAppEntry
import com.loc.newsapp.preferences.useCases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUsermanager(
        application: Application
    ):localUserManager= localUserManagerImp(application)

    @Provides
    @Singleton
    fun provideEntryCases(
        localUserManager : localUserManager
    ) = Cases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}