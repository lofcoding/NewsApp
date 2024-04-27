package com.loc.newsapp.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.preferences.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface localUserManager {
    suspend  fun saveAppEntry()
    fun readAppEntry() : Flow<Boolean>
}
class localUserManagerImp(private val context: Context): localUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {setting ->
            setting[PreferenceKeys.App_Entry] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {preferences ->
            preferences[PreferenceKeys.App_Entry] ?: false
        }
    }
}
private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = Constants.User_Settings )
private object PreferenceKeys {
    val App_Entry = booleanPreferencesKey(name = Constants.Pref_Key)
}