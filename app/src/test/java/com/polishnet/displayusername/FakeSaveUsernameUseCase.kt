package com.polishnet.displayusername

import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCase
import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCaseInterface

class FakeSaveUsernameUseCase (
    private val fakeDisplayUsernameRepository: FakeDisplayUsernameRepository
) : SaveUsernameUseCaseInterface{
    override suspend operator fun invoke(username: String) {
        fakeDisplayUsernameRepository.saveUsername(username)
    }

}