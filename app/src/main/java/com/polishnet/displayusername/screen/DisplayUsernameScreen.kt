package com.polishnet.displayusername.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@Composable
fun DisplayUsernameScreen(
    displayUserNameViewModel: DisplayUserNameViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        displayUserNameViewModel.displayUsername()
    }
    val displayUsernameUIState by displayUserNameViewModel.displayUsername.collectAsStateWithLifecycle()
    var text by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember{SnackbarHostState()}
    var isValid by remember { mutableStateOf(false) }

   Scaffold(
       snackbarHost = {
           SnackbarHost(hostState = snackbarHostState)
       }

   ) { paddingValues ->
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(paddingValues = paddingValues),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           Text(
               text = displayUsernameUIState.username?:"",
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
               onValueChange = { input ->
                   text = input
                   isValid = input.isEmpty()
                               },
               label = { Text("Enter username") },
               isError = text.isEmpty()

           )
           Spacer(
               modifier = Modifier.height(16.dp)
           )
           Button(
               onClick = {
                   if (!isValid) {
                       displayUserNameViewModel.saveUsername(text)
                       scope.launch {
                           snackbarHostState.showSnackbar("Usename is saved")
                       }
                   } else {
                       scope.launch {
                           snackbarHostState.showSnackbar("Usename icannot be empty")
                       }
                   }

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
                   val hasSavedUsername = displayUsernameUIState.username?:""
                   if (!hasSavedUsername.isEmpty()) {
                       displayUserNameViewModel.displayUsername()
                   } else {
                       scope.launch {
                           snackbarHostState.showSnackbar("No previous username saved; please enter a username")
                       }
                   }

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

}