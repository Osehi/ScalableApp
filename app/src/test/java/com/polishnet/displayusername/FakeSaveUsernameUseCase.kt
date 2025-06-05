package com.polishnet.displayusername

import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCase

class FakeSaveUsernameUseCase (
    private val fakeDisplayUsernameRepository: FakeDisplayUsernameRepository
) {
    suspend operator fun invoke(username: String) {
        fakeDisplayUsernameRepository.saveUsername(username)
    }
}