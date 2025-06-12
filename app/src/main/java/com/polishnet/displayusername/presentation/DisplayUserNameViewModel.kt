package com.polishnet.displayusername.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polishnet.displayusername.domain.usecase.GetUsernameUseCase
import com.polishnet.displayusername.domain.usecase.GetUsernameUseCaseInterface
import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCase
import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCaseInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisplayUserNameViewModel @Inject constructor(
    private val getUsernameUseCase: GetUsernameUseCaseInterface,
    private val saveUsernameUseCase: SaveUsernameUseCaseInterface
): ViewModel() {

    // save username action
    fun saveUsername(username: String) {
        // receives the username and save to preference
        viewModelScope.launch {
            saveUsernameUseCase(username)
        }
    }

    // display username
    val displayUsername: StateFlow<DisplayUsernameState> = getUsernameUseCase()
        .map {
            username -> DisplayUsernameState(username = username?: "")
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            DisplayUsernameState(username = "")
        )

}