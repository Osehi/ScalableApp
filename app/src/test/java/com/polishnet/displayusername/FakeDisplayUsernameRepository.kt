package com.polishnet.displayusername

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeDisplayUsernameRepository: DisplayUserNameRepository {
    private var storage = ""
    override fun getUsername(): Flow<String?> {
        return flowOf(storage)
    }

    override suspend fun saveUsername(username: String) {
        storage = username
    }
}