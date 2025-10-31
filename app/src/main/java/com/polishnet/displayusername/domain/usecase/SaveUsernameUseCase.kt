package com.polishnet.displayusername.domain.usecase

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import com.polishnet.displayusername.domain.DisplayUsernameRoomRepository
import javax.inject.Inject

class SaveUsernameUseCase @Inject constructor(
    private val displayUserNameRepository: DisplayUserNameRepository,
    private val displayUsernameRoomRepository: DisplayUsernameRoomRepository
) {
    suspend operator fun invoke(username: String) {
        displayUsernameRoomRepository.saveUsername(username)
    }
}