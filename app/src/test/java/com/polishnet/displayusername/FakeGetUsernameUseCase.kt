package com.polishnet.displayusername

import kotlinx.coroutines.flow.Flow

class FakeGetUsernameUseCase(
    private  val fakeDisplayUsernameRepository: FakeDisplayUsernameRepository
) {
    operator fun invoke(): Flow<String?> {
        return fakeDisplayUsernameRepository.getUsername()
    }
}