package com.loc.newsapp.preferences.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.preferences.utils.Constants.Pref_Key
import com.loc.newsapp.preferences.utils.Constants.User_Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

open class AppEntry {
    suspend  fun saveAppEntry(context: Context){
        context.dataStore.edit {setting ->
            setting[PreferenceKeys.App_Entry] = true
        }
    }
    fun readAppEntry(context: Context) : Flow<Boolean>{
        return context.dataStore.data.map {preferences ->
            preferences[PreferenceKeys.App_Entry] ?: false
        }
    }
}



private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = User_Settings )
private object PreferenceKeys {
    val App_Entry = booleanPreferencesKey(name = Pref_Key)
}