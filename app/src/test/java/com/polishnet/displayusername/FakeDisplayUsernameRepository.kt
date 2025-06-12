package com.polishnet.displayusername

import com.polishnet.displayusername.domain.DisplayUserNameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

class FakeDisplayUsernameRepository: DisplayUserNameRepository {
    private var _storage = MutableStateFlow<String?>("")
    override fun getUsername(): Flow<String?> {
        return _storage
    }

    override suspend fun saveUsername(username: String) {
//        _storage.value = username
        _storage.value = username
    }
}