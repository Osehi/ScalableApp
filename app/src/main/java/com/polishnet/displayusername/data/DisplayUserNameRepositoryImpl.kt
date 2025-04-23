package com.polishnet.displayusername.data

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DisplayUserNameRepositoryImpl @Inject constructor(
    private val displayUsernamePreferenceLocalDataSource: DisplayUsernamePreferenceLocalDataSource
): DisplayUserNameRepository {
    override fun getUsername(): Flow<String?> {
        return displayUsernamePreferenceLocalDataSource.getUserName()
    }

    override suspend fun saveUsername(username: String) {
       displayUsernamePreferenceLocalDataSource.saveUserName(username)
    }
}