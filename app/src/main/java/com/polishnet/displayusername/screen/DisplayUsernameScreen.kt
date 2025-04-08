package com.polishnet.displayusername.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polishnet.displayusername.presentation.DisplayUserNameViewModel

@Composable
fun DisplayUsernameScreen(
    displayUserNameViewModel: DisplayUserNameViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        displayUserNameViewModel.displayUsername()
    }
    val displayUsernameUIState by displayUserNameViewModel.displayUsername.collectAsStateWithLifecycle()
    var text by remember { mutableStateOf("") }
//    var text = ""
    var retrievedUsername  by remember { mutableStateOf("") }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = retrievedUsername,
            style = TextStyle(
                fontSize = 22.sp
            ),
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        OutlinedTextField(
            value = text ,
            onValueChange = {text = it},
            label = { Text("Enter username") }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {
                displayUserNameViewModel.saveUsername(text)
                Log.e("user","see saved value: - ${text}")
            }
        ) {
            Text(
                text = "Save Username",
                style = TextStyle(
                    fontSize = 22.sp
                ),
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {
                displayUserNameViewModel.displayUsername()
                retrievedUsername = displayUsernameUIState.username?:""
                Log.e("user","see retrieved value: - ${retrievedUsername}")
            }
        ) {
            Text(
                text = "Display Username",
                style = TextStyle(
                    fontSize = 22.sp
                ),
                fontWeight = FontWeight.Bold
            )
        }

    }
}