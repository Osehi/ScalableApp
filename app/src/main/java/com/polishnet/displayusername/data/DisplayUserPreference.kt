package com.polishnet.displayusername.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DisplayUserPreference @Inject constructor(private val context: Context): Preference{

    companion object {
        const val PREFERENCE_NAME = "DISLAY_USER_NAME_PREFERENCE"
    }
    private val Context.dataStore by preferencesDataStore(
        name = PREFERENCE_NAME
    )

    override suspend fun saveUserName(userName: String) {
        context.dataStore.edit { userSetting ->
            userSetting[stringPreferencesKey(PreferenceConstant.SAVE_USERNAME)] = userName
        }
    }

    override suspend fun getUserName(): String? {
        return context.dataStore.data.map { userSetting ->
            userSetting[stringPreferencesKey(PreferenceConstant.SAVE_USERNAME)]
        }.first()
    }


}