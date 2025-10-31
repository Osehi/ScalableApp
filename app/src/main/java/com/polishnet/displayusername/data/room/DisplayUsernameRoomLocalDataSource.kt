package com.polishnet.displayusername.data.room

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DisplayUsernameRoomLocalDataSource @Inject constructor(
    private val roomStore: UsernameDao
) : RoomActions{
    override suspend fun saveUsername(username: String) {
        roomStore.insertMyUsername(UsernameEntity(myUsername = username))
    }

    override fun getUsername(): Flow<UsernameEntity> {
       return roomStore.getSavedUsername()
    }
}