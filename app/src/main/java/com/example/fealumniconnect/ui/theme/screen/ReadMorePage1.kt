package com.example.fealumniconnect.ui.theme.screen

import Header
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.fealumniconnect.R
import com.example.fealumniconnect.ui.theme.screen.composable.BottomNavigationBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReadMorePage1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 15.dp),
        contentAlignment = Alignment.TopStart
    ){
        Header(title = "Kembali")
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(44.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Alibaba Cloud Laksanakan Workshop Memahami Dunia Cloud Computing di Fasilkom-TI USU",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(700),
                color = Color.Black,)
        )
        Image(
            painter = painterResource(id = R.drawable.gambar1),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(335.dp)
                .height(180.dp)
        )
        Text(
            text = "Alibaba Cloud has conducted a workshop on Understanding the World of Cloud Computing at the Faculty of Computer Science and Information Technology (Fasilkom-TI), University of North Sumatra (USU). This workshop was held at the USU Faculty of Economics and Business (FEB) Hall on Wednesday, September 13, 2022.\nAlibaba Cloud is the digital technology and intelligence backbone of Alibaba Group, and one of the three leading IaaS (Infrastructure as a Service) providers in the world. Alibaba Cloud is also the largest public cloud service provider in China. Currently Alibaba Cloud has 3 Data Centers (Data Center) and 1 Scrubbing Center in Indonesia. This workshop is a form of support and cooperation from Fasilkom-TI towards Alibaba Cloud.\nThe workshop began with an opening by the MC (Master Ceremony) followed by remarks from the Dean of Fasilkom-TI, Dr. Maya Silvi Lydia, B.Sc, M.Sc. In his remarks, the Dean of Fasilkom-TI said that the presence of cloud computing can help make decisions from big data to be efficient with a high priority scale. He also added that this activity is the first step for cooperation with Alibaba Cloud.\nThen continued with the presentation of material by Aaron Berliano Handoko, namely Alibaba Cloud Indonesia Marketing Technical Manager. The presentation of the material begins with the introduction and application of cloud computing in everyday life. The material continued with the introduction of Alibaba Cloud and what its products are. The participants who attended received a certificate from Alibaba Cloud.",
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight(300),
                color = Color(0xFF000000),
                textAlign = TextAlign.Justify,)
        )
        Image(painter = painterResource(id = R.drawable.gambar2),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(335.dp)
                .height(180.dp)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 15.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        BottomNavigationBar()
    }
}


/*
private fun Any.Box(
    contentAlignment: Alignment.Vertical,
    modifier: Modifier.Companion,
    content: @Composable() (BoxScope.() -> Unit)
) {}
*/
@RequiresApi(Build.VERSION_CODES.O)
@Preview (widthDp = 428, heightDp = 1352)
@Composable
private fun ReadMorePagePreview(){
    ReadMorePage1()
}
