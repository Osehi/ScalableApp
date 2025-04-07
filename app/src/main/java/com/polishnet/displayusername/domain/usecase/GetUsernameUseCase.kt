package com.polishnet.displayusername.domain.usecase

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import javax.inject.Inject

class GetUsernameUseCase @Inject constructor(
    private val displayUserNameRepository: DisplayUserNameRepository
) {
    suspend operator fun invoke(): String? {
        return displayUserNameRepository.getUsername()
    }
}