package com.example.fealumniconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
import com.example.fealumniconnect.ui.screens.LoginScreen
import com.example.fealumniconnect.ui.theme.BackgroundColor
import com.example.fealumniconnect.ui.theme.FEAlumniConnectTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FEAlumniConnectTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = BackgroundColor, modifier = Modifier.fillMaxSize()) {
                    LoginScreen()
                }
            }
        }
    }
}
