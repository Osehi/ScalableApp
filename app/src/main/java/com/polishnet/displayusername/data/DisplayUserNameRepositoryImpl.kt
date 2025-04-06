package com.polishnet.displayusername.data

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import javax.inject.Inject

class DisplayUserNameRepositoryImpl @Inject constructor(
    private val displayUserNameLocalDataSource: Preference
): DisplayUserNameRepository {
    override suspend fun getUsername(): String? {
        return displayUserNameLocalDataSource.getUserName()
    }

    override suspend fun saveUsername(username: String) {
        displayUserNameLocalDataSource.saveUserName(username)
    }
}