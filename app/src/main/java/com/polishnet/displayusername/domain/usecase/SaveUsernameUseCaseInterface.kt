package com.polishnet.displayusername.domain.usecase

interface SaveUsernameUseCaseInterface {
    suspend operator fun invoke(username: String)
}