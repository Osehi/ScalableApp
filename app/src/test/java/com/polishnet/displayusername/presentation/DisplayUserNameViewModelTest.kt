package com.polishnet.displayusername.presentation

import android.util.Log
import app.cash.turbine.test
import com.polishnet.displayusername.FakeDisplayUsernameRepository
import com.polishnet.displayusername.FakeGetUsernameUseCase
import com.polishnet.displayusername.FakeSaveUsernameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.logging.Logger

@RunWith(JUnit4::class)
class DisplayUserNameViewModelTest {
    // What to test
    //  Actions DisplayUSername does
    // 1. it saves a username.
    //  2. it retrieves username from a storage [data store] and passes it to the UI

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup()  = Dispatchers.setMain(StandardTestDispatcher())

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() = Dispatchers.resetMain()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveInto_displayUsernameViewModel() = runTest{
        val fakeDisplayUsernameRepository = FakeDisplayUsernameRepository()
        val fakeSaveUsernameUseCase = FakeSaveUsernameUseCase(fakeDisplayUsernameRepository)
        val fakeGetUsernameUseCase = FakeGetUsernameUseCase(fakeDisplayUsernameRepository)
        val displayUsernameViewModel = DisplayUserNameViewModel(
            getUsernameUseCase =  fakeGetUsernameUseCase,
            saveUsernameUseCase =  fakeSaveUsernameUseCase
        )
        // Given
        val username = "Osehi"
        // Action
        displayUsernameViewModel.saveUsername(username)
        // let emission happen
        runCurrent()
        val getUsername = displayUsernameViewModel.displayUsername.value.username
        // assert
        assertEquals("Osehi",getUsername )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveMyUsername_assertTrueSavedUsername() = runTest{
        val fakeDisplayUsernameRepository = FakeDisplayUsernameRepository()
        val fakeSaveUsernameUseCase = FakeSaveUsernameUseCase(fakeDisplayUsernameRepository)
        val fakeGetUsernameUseCase = FakeGetUsernameUseCase(fakeDisplayUsernameRepository)
        val displayUsernameViewModel = DisplayUserNameViewModel(
            getUsernameUseCase =  fakeGetUsernameUseCase,
            saveUsernameUseCase =  fakeSaveUsernameUseCase
        )
        // Given
        val username = "Osehi"
        // pass the username
        displayUsernameViewModel.saveUsername(username)

        // Action
        displayUsernameViewModel.displayUsername.test {
            awaitItem()

            val emittedState = awaitItem()
            assertEquals(username, emittedState.username)
            cancelAndIgnoreRemainingEvents()
        }

    }
}