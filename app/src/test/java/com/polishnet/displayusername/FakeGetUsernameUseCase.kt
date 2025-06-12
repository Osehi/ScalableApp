package com.polishnet.displayusername

import com.polishnet.displayusername.domain.usecase.GetUsernameUseCaseInterface
import kotlinx.coroutines.flow.Flow

class FakeGetUsernameUseCase(
    private  val fakeDisplayUsernameRepository: FakeDisplayUsernameRepository
) : GetUsernameUseCaseInterface{
    override operator fun invoke(): Flow<String?> {
        return fakeDisplayUsernameRepository.getUsername()
    }
}