package com.polishnet.displayusername.domain

import com.polishnet.displayusername.data.room.UsernameEntity
import kotlinx.coroutines.flow.Flow

interface DisplayUsernameRoomRepository {
    fun getUsername(): Flow<UsernameEntity>
    suspend fun saveUsername(username: String)
}