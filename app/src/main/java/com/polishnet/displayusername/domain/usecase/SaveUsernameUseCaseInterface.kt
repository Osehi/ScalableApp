package com.polishnet.displayusername.domain.usecase

interface SaveUsernameUseCaseInterface {
    suspend fun saveUsername(username: String)
}