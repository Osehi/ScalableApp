package com.polishnet.displayusername.domain.usecase

import com.polishnet.displayusername.data.room.UsernameEntity
import com.polishnet.displayusername.domain.DisplayUserNameRepository
import com.polishnet.displayusername.domain.DisplayUsernameRoomRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsernameUseCase @Inject constructor(
    private val displayUserNameRepository: DisplayUserNameRepository,
    private val displayUsernameRoomRepository: DisplayUsernameRoomRepository
) {
    operator fun invoke(): Flow<UsernameEntity> {
        return displayUsernameRoomRepository.getUsername()
    }
}