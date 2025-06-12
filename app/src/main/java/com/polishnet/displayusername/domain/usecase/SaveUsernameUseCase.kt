package com.polishnet.displayusername.domain.usecase

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import javax.inject.Inject

class SaveUsernameUseCase @Inject constructor(
    private val displayUserNameRepository: DisplayUserNameRepository
): SaveUsernameUseCaseInterface {
    override suspend operator fun invoke(username: String) {
        displayUserNameRepository.saveUsername(username)
    }

}