package com.polishnet.displayusername.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polishnet.displayusername.domain.usecase.GetUsernameUseCase
import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisplayUserNameViewModel @Inject constructor(
    private val getUsernameUseCase: GetUsernameUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase
): ViewModel() {

    private var _displayUsername = MutableStateFlow(DisplayUsernameState(""))
    val displayUsername: StateFlow<DisplayUsernameState> = _displayUsername

    // save username action
    fun saveUsername(username: String) {
        // receives the username and save to prefernce
        viewModelScope.launch {
            saveUsernameUseCase(username)
            Log.e("user","see  savedUsername in viewmodel: - ${username}")
        }
    }

    // display username action
    fun displayUsername() {
        viewModelScope.launch {
            _displayUsername.update {
                it.copy(
                    username = getUsernameUseCase()
                )

            }
            Log.e("user","see retrieved username in viewmodel: - ${getUsernameUseCase()}")
        }
    }
}