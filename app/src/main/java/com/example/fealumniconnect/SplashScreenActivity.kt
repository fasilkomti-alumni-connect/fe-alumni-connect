package com.example.fealumniconnect

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                SplashScreen()
            }
        }
    }
    @Preview
    @Composable
    private fun SplashScreen() {
        LaunchedEffect(key1 = true){
            delay(3000)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
            , contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id =  R.drawable.body),
                contentDescription = null)
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
            , contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id =  R.drawable.head),
                contentDescription = null)
        }
    }



}


}