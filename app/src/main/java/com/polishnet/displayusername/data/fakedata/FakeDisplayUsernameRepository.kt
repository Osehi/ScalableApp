package com.polishnet.displayusername.data.fakedata

import android.util.Log
import com.polishnet.displayusername.domain.DisplayUserNameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

class FakeDisplayUsernameRepository: DisplayUserNameRepository {
    private var _savedUsername = MutableStateFlow<String?>(null)

    override fun getUsername(): Flow<String?> {
//        return  flowOf("Test Username")
        return _savedUsername
    }

    override suspend fun saveUsername(username: String) {
        Log.e("FAKE_REPO", "Saved username: $username")
       _savedUsername.value = username
    }
}