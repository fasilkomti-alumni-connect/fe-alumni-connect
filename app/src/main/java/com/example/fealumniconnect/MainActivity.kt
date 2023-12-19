package com.example.fealumniconnect

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fealumniconnect.ui.theme.FEAlumniConnectTheme
import com.example.fealumniconnect.ui.theme.screen.ReadMorePage1
import com.example.fealumniconnect.ui.theme.screen.ReadMorePage2
import com.example.fealumniconnect.ui.theme.screen.ReadMorePage3
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navigation()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ){
        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        composable("main_screen"){
            FEAlumniConnectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Hello Alumni Project!")

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            navController.navigate("read_more_page1")
                        },
                        modifier = Modifier.padding(100.dp)
                    ) {
                        Text("Read More Page 1")
                    }
                    Button(
                        onClick = {
                            navController.navigate("read_more_page2")
                        },
                        modifier = Modifier.padding(100.dp)
                    ) {
                        Text("Read More Page 2")
                    }
                    Button(
                        onClick = {
                            navController.navigate("read_more_page3")
                        },
                        modifier = Modifier.padding(100.dp)
                    ) {
                        Text("Read More Page 3")
                    }
                }
            }
        }
        composable("read_more_page1") {
            ReadMorePage1()
        }
        composable("read_more_page2") {
            ReadMorePage2()
        }
        composable("read_more_page3") {
            ReadMorePage3()
        }
        composable("default") {
            Text("Ups! ada Masalah")
        }
    }
    LaunchedEffect(key1 = true){
        delay(1500L)
        navController.navigate("main_screen")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name")
}

@Composable
fun SplashScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        //Image rounded logo
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier
            .size(100.dp)
            .border(width = 4.dp, color = Color.Transparent, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.head),
                contentDescription = "Logo",
                modifier = Modifier.fillMaxSize()
            )
        }


        Box(modifier = Modifier
            .width((IntrinsicSize.Max))
            .border(width = 4.dp, color = Color.Transparent, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Welcome to", style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
            )
        }

        Box(modifier = Modifier
            .width((IntrinsicSize.Max))
            .border(width = 4.dp, color = Color.Transparent, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Alumni Connect", style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier
            .width((IntrinsicSize.Max))
            .border(width = 4.dp, color = Color.Transparent, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Fakultas Ilmu Komputer dan Teknologi Informasi Universitas Sumatera Utara", style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Center)
            )
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .border(width = 4.dp, color = Color.Transparent, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.body),
                contentDescription = "body",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
