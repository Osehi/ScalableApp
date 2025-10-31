package com.polishnet.displayusername.data.room

import kotlinx.coroutines.flow.Flow

interface RoomActions {
    // save and get username
    suspend fun saveUsername(username: String)
    fun getUsername(): Flow<UsernameEntity>
}