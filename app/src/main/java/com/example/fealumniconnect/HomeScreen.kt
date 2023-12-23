package com.example.fealumniconnect

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fealumniconnect.ReadMore
import com.example.fealumniconnect.ui.theme.DarkerGreen
import com.example.fealumniconnect.ui.theme.Outline
import com.example.fealumniconnect.ui.theme.Poppins


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Toolbar()

        Spacer(modifier = Modifier.height(5.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            val card1 = CardInfo(
                imageResourceId = R.drawable.img_1,
                title = "Ipsum nunc aliquet bibendum enim facilisis gravida neque convallis ",
                date = "xx xxxxxx xxxx",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sapien et ligula ullamcorper malesuada proin libero nunc. Lobortis scelerisque fermentum dui faucibus in. Eu nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper. Sit amet commodo nulla facilisi nullam. Risus pretium quam vulputate dignissim suspendisse. Vel facilisis volutpat est velit egestas. Orci sagittis eu volutpat odio facilisis mauris sit amet."
            )

            val card2 = CardInfo(
                imageResourceId = R.drawable.img_2,
                title = "Diam sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae aliquet",
                date = "xx xxxxxx xxxx",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc sed blandit libero volutpat sed cras ornare arcu. Phasellus egestas tellus rutrum tellus pellentesque eu tincidunt tortor aliquam. Enim nunc faucibus a pellentesque sit amet porttitor eget dolor. Velit laoreet id donec ultrices tincidunt arcu non. A erat nam at lectus urna duis convallis convallis."
            )

            val card3 = CardInfo(
                imageResourceId = R.drawable.img_3,
                title = "Enim ut sem viverra aliquet eget sit amet tellus cras adipiscing enim",
                date = "xx xxxxxx xxxx",
                description = "Adipiscing at in tellus integer feugiat scelerisque. Ullamcorper velit sed ullamcorper morbi tincidunt ornare. Turpis in eu mi bibendum neque egestas congue. Sit amet luctus venenatis lectus magna. Suspendisse in est ante in nibh mauris cursus mattis molestie."
            )

            item {
                ContentCard(card1)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                ContentCard(card2)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                ContentCard(card3)
            }
        }

//        BottomNavigationBar()
    }
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(horizontal = 2.dp, vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ToolbarIcon(iconResId = R.drawable.user, isSelected = false)

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Hello, Kokotiii Said!",
            fontFamily = Poppins,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 2.dp)
        )


        Spacer(modifier = Modifier.weight(1f))

        ToolbarIcon(iconResId = R.drawable.bell, isSelected = false)
    }
}

@Composable
fun ToolbarIcon(@DrawableRes iconResId: Int, isSelected: Boolean) {
    val iconColor = if (isSelected) Color.White else Color.Gray

    Box(
        modifier = Modifier
            .background(
                color = DarkerGreen,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(2.dp)
            .clickable { }
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier.size(22.dp)
        )
    }
}

@SuppressLint("ComposableDestinationInComposeScope")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContentCard(cardInfo: CardInfo) {
    val navController = rememberNavController()
    var expanded by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .width(280.dp)
                .height(240.dp),
            elevation = CardDefaults.cardElevation(1.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = cardInfo.imageResourceId),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(130.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = cardInfo.title,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 10.sp,
                    style = TextStyle(
                        lineHeight = 10.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(1.dp))

                Text(
                    text = cardInfo.date,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.ExtraLight,
                    color = Color.LightGray,
                    fontSize = 9.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )
//
                Spacer(modifier = Modifier.height(4.dp))

                if (expanded) {
                    Text(
                        text = cardInfo.description,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Thin,
                        fontSize = 10.sp,
                        style = TextStyle(
                            lineHeight = 10.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    )
                } else {
                    Text(
                        text = cardInfo.description.take(100),
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Thin,
                        fontSize = 10.sp,
                        style = TextStyle(
                            lineHeight = 10.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    )

                    TextButton(
                        onClick = {
                                  navController.navigate("read_more_page")
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(
                            "Read More",
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            color = Outline
                        )
                    }
                }
            }
        }

    }
}

data class CardInfo(
    val imageResourceId: Int,
    val title: String,
    val date : String,
    val description: String
)

//@Composable
//fun BottomNavigationBar() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(75.dp)
//            .background(color = Color.White),
//        horizontalArrangement = Arrangement.SpaceAround,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        BottomNavItem(iconResId = R.drawable.home, label = "", isSelected = false)
//        BottomNavItem(iconResId = R.drawable.event, label = "", isSelected = false)
//        BottomNavItem(iconResId = R.drawable.calendar, label = "", isSelected = false)
//        BottomNavItem(iconResId = R.drawable.globe, label = "", isSelected = false)
//        BottomNavItem(iconResId = R.drawable.user, label = "", isSelected = false)
//    }
//}
//@Composable
//fun BottomNavItem(@DrawableRes iconResId: Int, label: String, isSelected: Boolean) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .clickable { /* Handle navigation here */ }
//    ) {
//        Image(
//            painter = painterResource(id = iconResId),
//            contentDescription = null,
//            colorFilter = ColorFilter.tint(if (isSelected) Color.White else Color.Gray),
//            modifier = Modifier.size(30.dp)
//        )
//    }
//}
