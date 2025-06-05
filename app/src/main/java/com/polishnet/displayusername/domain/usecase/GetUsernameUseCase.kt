package com.polishnet.displayusername.domain.usecase

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsernameUseCase @Inject constructor(
    private val displayUserNameRepository: DisplayUserNameRepository
) : GetUsernameUseCaseInterface{
    override fun invoke(): Flow<String?> {
        return displayUserNameRepository.getUsername()
    }

}