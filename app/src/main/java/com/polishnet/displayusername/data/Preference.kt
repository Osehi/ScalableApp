package com.polishnet.displayusername.data

interface Preference {
    suspend fun saveUserName(userName: String)
    suspend fun getUserName(): String?
}