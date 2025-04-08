package com.polishnet.displayusername

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.polishnet.displayusername.presentation.DisplayUserNameViewModel
import com.polishnet.displayusername.screen.DisplayUsernameScreen
import com.polishnet.displayusername.ui.theme.DisplayUserNameTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DisplayUserNameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayUsernameScreen()

                }


                /*
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                 */

            }
        }
    }
}

/**
 * => Sunday 6th April, 2025
 * The Task To Do After Church
 * 1. To complete this app and review with my Mentor - Joseph
 *  2. Build a UI =>  the components are
 *  a. Display Text View
 *  b. An Input field View
 *  c. A Save-Button.
 *  d. A Display-Username-Button.
 */

@Composable
fun DisplayUsername() {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "My Username is Osehiase",
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
            label = { Text("Enter username")}
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {}
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
            onClick = {}
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DisplayUserNameTheme {
        Greeting("Android")
    }
}