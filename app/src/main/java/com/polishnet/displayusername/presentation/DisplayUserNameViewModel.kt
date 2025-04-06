package com.polishnet.displayusername.presentation

import androidx.lifecycle.ViewModel
import com.polishnet.displayusername.domain.usecase.GetUsernameUseCase
import com.polishnet.displayusername.domain.usecase.SaveUsernameUseCase
import javax.inject.Inject

class DisplayUserNameViewModel @Inject constructor(
    private val getUsernameUseCase: GetUsernameUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase
): ViewModel() {
}