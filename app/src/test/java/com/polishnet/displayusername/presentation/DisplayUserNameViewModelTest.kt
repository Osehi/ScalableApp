package com.polishnet.displayusername.presentation

import com.polishnet.displayusername.FakeDisplayUsernameRepository
import com.polishnet.displayusername.FakeGetUsernameUseCase
import com.polishnet.displayusername.FakeSaveUsernameUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class DisplayUserNameViewModelTest {
    // What to test
    //  Actions DisplayUSername does
    // 1. it saves a username.
    //  2. it retrieves username from a storage [data store] and passes it to the UI

    @Test
    fun saveInto_displayUsernameViewModel() = runTest{
        val fakeDisplayUsernameRepository = FakeDisplayUsernameRepository()
        val fakeSaveUsernameUseCase = FakeSaveUsernameUseCase(fakeDisplayUsernameRepository)
        val fakeGetUsernameUseCase = FakeGetUsernameUseCase(fakeDisplayUsernameRepository)
        val displayUsernameViewModel = DisplayUserNameViewModel(
            fakeGetUsernameUseCase,
            fakeSaveUsernameUseCase
        )
    }
}