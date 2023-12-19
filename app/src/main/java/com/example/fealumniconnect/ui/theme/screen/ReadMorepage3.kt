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
fun ReadMorePage3() {
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
            text = "Fasilkom-TI Representative Team Wins Fordigi Hackathon Challenge 2023 Competition",
            style = TextStyle(
                fontSize = 15.sp,
//                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(700),
                color = Color.Black,
            )
        )

        Text(
            text = "A total of three teams from the Faculty of Computer Science and Information Technology (Fasilkom-TI) of the University of North Sumatra (USU) won the Fordigi Hackathon Challenge 2023 competition held on Tuesday, August 29, 2023 at the USU Student Center.\n" +
                    "Fordigi Goes to Campus was organized by Jasa Raharja and the Digital Forum (Fordigi) of State-Owned Enterprises (BUMN). USU became the sixth university visited by this activity. The Fordigi Goes to Campus City Chapter VI-Medan activity raised the theme 'The future of digital mortgage'. Some of the series of activities are hybrid seminars, Fordigi Hackathon Challenge competition, Deep Racer League competition, and Call for Paper on Personal Data Protection Law (PDP).\n" +
            "Fordigi or previously known as Forti BUMN (BUMN Information Technology Forum) is a partner of the Ministry of BUMN in developing a global standard digital ecosystem and talent in BUMN. Fordigi is supported by the Ministry of SOEs to coordinate and organize the SOE Digital Talent Program.\n" +
                    "Fordigi Hackathon Challenge is a competition that aims to attract digital talents from among students who are able to become problem solvers for issues in their respective regions. The five priority programs that have been set by the Mayor of Medan are health, infrastructure management, flood management & cleanliness, and revamping heritage areas as well as empowering MSMEs.\n" +
            "The first winner of the Fordigi Hackathon Challenge was won by the Tanimed Team, one of whose members is a student of Fasilkom-TI, namely Deza Banjarnahor from Information Technology 2021. The Tanimed team brought a solution to solve the problem of one of the five priority programs of the city of Medan, namely the health program in the focus area of stunting. The Tanimed team designed the solution in a high-fidelity prototype called Endstunting. The main feature of Endstunting is tracking and monitoring children's growth and development using artificial intelligence. In the next stage, Tanimed Team will be the representative of City Chapter Medan to participate in the National Fordigi Hackathon Final which will be held in Jakarta.",
            style = TextStyle(
                fontSize = 13.sp,
//                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(300),
                color = Color(0xFF000000),
                textAlign = TextAlign.Justify,)
        )
        Image(painter = painterResource(id = R.drawable.gambar5),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(335.dp)
                .height(180.dp)
        )
        Text(
            text = "The 3rd place winner of the Fordigi Hackathon Challenge was won by the Parentify Team with two of its three members being Fasilkom-TI students, namely Deza Banjarnahor and Ridopandi Sinaga from Information Technology 2021. The Parentify team brought a solution about parenting or parenting by targeting solutions to the problems of the city of Medan in the first program, namely health and the fourth program, namely cleanliness. The parentify team produces high-fidelity prototype products with the aim of being a learning application design by applying artificial intelligence by adjusting the user's level of understanding of parenting.",
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight(300),
                color = Color(0xFF000000),
                textAlign = TextAlign.Justify,)
        )
        Image(painter = painterResource(id = R.drawable.gambar6),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(335.dp)
                .height(180.dp)
        )

        Text(
            text = "The Fordigi Hackathon Challenge Favorite Champion was won by the Techy Wizards Team led by Andhika Mandalanta Saragih and two members, Rani Widya Astuti and Pieter Tanoto from Computer Science 2021. The Techy Wizards team presented an application design by supporting the five priority programs of Medan City in the first program, namely health and the fourth program, namely cleanliness. The application design was made with the aim to help people find the nearest waste bank online and provide education to the people of Medan City on how to manage waste properly.",
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight(300),
                color = Color(0xFF000000),
                textAlign = TextAlign.Justify,)
        )
        Image(painter = painterResource(id = R.drawable.gambar7),
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview (widthDp = 428, heightDp = 1352)
@Composable
private fun ReadMorePagePreview(){
    ReadMorePage3()
}
