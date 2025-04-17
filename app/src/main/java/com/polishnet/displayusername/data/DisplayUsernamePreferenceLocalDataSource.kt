package com.polishnet.displayusername.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.polishnet.displayusername.data.PreferenceConstant.SAVE_USERNAME
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DisplayUsernamePreferenceLocalDataSource @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : Preference{
    override suspend fun saveUserName(userName: String) {
        dataStore.edit { userSetting ->
            userSetting[stringPreferencesKey(SAVE_USERNAME)] = userName
        }
    }

    override suspend fun getUserName(): String? {
        return dataStore.data.map { userSetting ->
            userSetting[stringPreferencesKey(SAVE_USERNAME)]
        }.first()
    }
}