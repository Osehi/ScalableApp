package com.polishnet.displayusername.data.room

import com.polishnet.displayusername.domain.DisplayUsernameRoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DisplayUsernameRoomRepositoryImpl @Inject constructor(
    private val displayUsernameRoomLocalDataSource: DisplayUsernameRoomLocalDataSource
):DisplayUsernameRoomRepository {
    override fun getUsername(): Flow<UsernameEntity> {
        return displayUsernameRoomLocalDataSource.getUsername()
    }

    override suspend fun saveUsername(username: String) {
        displayUsernameRoomLocalDataSource.saveUsername(username)
    }
}