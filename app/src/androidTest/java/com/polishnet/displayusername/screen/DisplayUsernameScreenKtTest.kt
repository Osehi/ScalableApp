package com.polishnet.displayusername.screen

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class DisplayUsernameScreenKtTest {
    @get: Rule  val composeTestRule = createComposeRule()

    // Launch DisplayUSernameUI
    @Test
    fun displayUsernameUI() {
        // start the App
        composeTestRule.setContent {
            DisplayUsernameScreen(

            )
        }
    }
}