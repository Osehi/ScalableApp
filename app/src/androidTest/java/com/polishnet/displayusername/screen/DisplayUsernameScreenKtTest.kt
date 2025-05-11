package com.polishnet.displayusername.screen

import androidx.compose.ui.test.MainTestClock
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.polishnet.displayusername.MainActivity
import com.polishnet.displayusername.di.NetworkModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class DisplayUsernameScreenKtTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get: Rule (order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    // Launch DisplayUsernameUI
    @Test
    fun displayUsernameUI() {
        // start the App
        composeTestRule.setContent {
            DisplayUsernameScreen()
        }
    }
}