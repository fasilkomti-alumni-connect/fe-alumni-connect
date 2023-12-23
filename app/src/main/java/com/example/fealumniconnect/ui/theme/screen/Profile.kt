package com.example.fealumniconnect.ui.theme.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fealumniconnect.R
import com.example.fealumniconnect.navigation.Screens

@Composable
public fun Profile(navController: NavController) {
    // NavHost
    val navController : NavHostController = rememberNavController()

//    // Scaffold
//    scaffold(
//        scaffoldState = rememberScaffoldState(),
//        topBar = {
//            TopAppBar(navController)
//        }
//    ) { innerPadding ->
//
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
//        Header(title = "Profil")
        // Background image and user information
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .width(428.dp)
                .height(261.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.gedung),
                contentDescription = "BG Gedung",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(288.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fotoprofil),
                    contentDescription = "foto profil",
                    modifier = Modifier.size(86.dp)
                )
                Text(
                    text = "Dara",

                    // H-4/18px/Bold
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )
                Text(
                    text = "Dara Fadilah",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }

        }

        Box(
            contentAlignment = Alignment.BottomCenter,
        ){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.background(Color.White)
            ) {
                // Spacing
//        Spacer(modifier = Modifier.height(20.dp))

                // Card with menu items and Logout button
                CardDetail(navController = navController)


            }
        }
    }
}


@Composable
fun CardDetail(modifier: Modifier = Modifier, navController: NavHostController) {
//    val navController : NavHostController = rememberNavController()
    Card(
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp,),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(34.dp)
        )
        {
            // Menu items
            CardItem(
                iconResId = R.drawable.ic_user, label = "Edit Profile", routeDestination = "EditProfile.kt", navController = navController)
            CardItem(
                iconResId = R.drawable.ic_setting,
                label = "Pengaturan",
                routeDestination = "",
                navController = navController
            )
            CardItem(
                iconResId = R.drawable.ic_bantuan,
                label = "Pusat Bantuan",
                routeDestination = "",
                navController = navController
            )
            CardItem(
                iconResId = R.drawable.ic_info,
                label = "Tentang Kami",
                routeDestination = "",
                navController = navController
            )

            // Add some spacing between menu items and Logout button
            Spacer(modifier = Modifier.height(180.dp))

            // Logout button
            Button(
                onClick = { /* Handle logout */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff7aa764)),
//                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                modifier = Modifier
                    .width(380.dp)
                    .height(55.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Logout",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.weight(1f) // Occupy remaining space
                )
            }
        }
    }
}

@Composable
fun CardItem(
    @DrawableRes iconResId: Int,
    label: String,
    routeDestination: String,
    navController: NavHostController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
//            .clickable {
//            }
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = "Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = label,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.weight(1f)) // Occupy remaining space
        Icon(
            painter = painterResource(id = R.drawable.ic_right_arrow),
            contentDescription = "Right Arrow",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(widthDp = 428, heightDp = 926)
@Composable
private fun ProfilPreview() {
//    Profile(navController = navController)
}