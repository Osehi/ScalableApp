package com.polishnet.displayusername.data.fakedata

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeDisplayUsernameRepository: DisplayUserNameRepository {
    private var savedUsername = ""
    override fun getUsername(): Flow<String?> {
        return  flowOf("Test Username")
    }

    override suspend fun saveUsername(username: String) {
       savedUsername = username
    }
}