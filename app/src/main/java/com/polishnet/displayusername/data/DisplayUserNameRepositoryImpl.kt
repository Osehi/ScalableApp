package com.polishnet.displayusername.data

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import javax.inject.Inject

class DisplayUserNameRepositoryImpl @Inject constructor(
    private val displayUsernamePreferenceLocalDataSource: DisplayUsernamePreferenceLocalDataSource
): DisplayUserNameRepository {
    override suspend fun getUsername(): String? {
        return displayUsernamePreferenceLocalDataSource.getUserName()
    }

    override suspend fun saveUsername(username: String) {
       displayUsernamePreferenceLocalDataSource.saveUserName(username)
    }
}