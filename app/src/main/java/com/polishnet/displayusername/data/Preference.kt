package com.polishnet.displayusername.data

import kotlinx.coroutines.flow.Flow

interface Preference {
    suspend fun saveUserName(userName: String)
    fun getUserName(): Flow<String?>
}