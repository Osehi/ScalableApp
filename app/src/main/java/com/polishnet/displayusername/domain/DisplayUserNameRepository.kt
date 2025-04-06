package com.polishnet.displayusername.domain

interface DisplayUserNameRepository {
    suspend fun getUsername(): String?
    suspend fun saveUsername(username: String)
}