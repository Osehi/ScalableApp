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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polishnet.displayusername.R
import com.polishnet.displayusername.presentation.DisplayUserNameViewModel
import com.polishnet.displayusername.presentation.DisplayUsernameState
import kotlinx.coroutines.launch
@Composable
fun DisplayUsernameScreen(
    displayUsernameViewModel: DisplayUserNameViewModel = hiltViewModel()
) {
    val displayUsernameUIState by displayUsernameViewModel.displayUsername.collectAsStateWithLifecycle()
  DisplayUsernameScreen(
      username =displayUsernameUIState.username?:"",
      onClickSaveUsername = displayUsernameViewModel::saveUsername
  )

}


@Composable
internal fun DisplayUsernameScreen(
    username: String,
    onClickSaveUsername: (username: String) -> Unit
) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember{SnackbarHostState()}
    var isValid by remember { mutableStateOf(true) }

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
               modifier = Modifier.testTag("DisplayUsername"),
               text = username,
               style = TextStyle(
                   fontSize = 22.sp
               ),
               fontWeight = FontWeight.Bold
           )
           Spacer(
               modifier = Modifier.height(16.dp)
           )
           OutlinedTextField(
               modifier = Modifier.testTag("enter username"),
               value = text ,
               onValueChange = { input ->
                   text = input
                   isValid = input.isEmpty()
                   Log.e("username", "see status of isvalid: in input field-  ${isValid} and ${input.isEmpty()}")
                               },
               label = { Text(stringResource(id =  R.string.enter_name)) },
               isError = text.isEmpty()

           )
           Spacer(
               modifier = Modifier.height(16.dp)
           )
           Button(
               modifier = Modifier.testTag("SaveButton"),
               onClick = {
                   Log.e("username", "see status of isvalid:-  ${isValid}")
                   if (!isValid) {
                       onClickSaveUsername(text)
                       scope.launch {
                           snackbarHostState.showSnackbar(context.getString(R.string.username_saved))
                       }
                   } else {
                       scope.launch {
                           snackbarHostState.showSnackbar(context.getString(R.string.username_empty))
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

       }



   }

}