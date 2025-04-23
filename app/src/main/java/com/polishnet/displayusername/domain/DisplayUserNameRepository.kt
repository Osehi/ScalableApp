package com.polishnet.displayusername.domain

import kotlinx.coroutines.flow.Flow

interface DisplayUserNameRepository {
    fun getUsername(): Flow<String?>
    suspend fun saveUsername(username: String)
}