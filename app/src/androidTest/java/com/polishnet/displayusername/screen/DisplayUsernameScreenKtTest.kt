package com.polishnet.displayusername.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.polishnet.displayusername.HiltTestActivity
import com.polishnet.displayusername.ui.theme.DisplayUserNameTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class DisplayUsernameScreenKtTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get: Rule (order = 1)
    val composeTestRule =  createAndroidComposeRule<HiltTestActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    // Launch DisplayUsernameUI
    @Test
    fun displayUsernameUI() {
        // start the App
        composeTestRule.setContent {
            DisplayUserNameTheme {
                DisplayUsernameScreen()
            }

        }
        val textInput = "JosephAndroid"
        composeTestRule
            .onNodeWithTag("UsernameInput", useUnmergedTree = true)
            .assertIsDisplayed()
            .assertIsEnabled()
            .performClick()
            .performTextInput(textInput)

        composeTestRule
            .onNodeWithTag("SaveButton")
            .performClick()

        composeTestRule.waitUntil(
            timeoutMillis = 5000,
            condition = {
                try {
                    composeTestRule
                        .onNodeWithTag("DisplayUsername")
                        .assertTextContains(textInput)
                    true
                } catch (e: AssertionError) {
                    false
                }

            }
        )

        composeTestRule
            .onNodeWithTag("DisplayUsername")
            .assertIsEnabled()
            .assertTextContains(textInput)

    }
}