package com.polishnet.displayusername.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetUsernameUseCaseInterface {
    operator fun invoke(): Flow<String?>
}