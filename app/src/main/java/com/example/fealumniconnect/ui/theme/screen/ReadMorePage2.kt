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
fun ReadMorePage2() {
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
            text = "Fasilkom-TI Conducts International Student Mobility Program with School of Computing UUM",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(700),
                color = Color.Black,
            )
        )
        Image(painter = painterResource(id = R.drawable.gambar3),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(335.dp)
                .height(180.dp)
        )
        Text(
            text = "The Faculty of Computer Science and Information Technology (Fasilkom-TI) of the University of North Sumatra (USU) has conducted an International Student Mobility Program with the School of Computing Universiti Utara Malaysia (UUM) on Monday, September 18, 2023 in the Seminar Room Building C Fasilkom-TI.\n" +
                    "The activity began with the opening by the Master Ceremony (MC), singing the Indonesia Raya song, reading prayers, remarks from the Deputy Dean of UUM representative Prof. Madya Ts. Dr. Mohamad Fadli Zolkipli, and remarks from the Dean of Fasilkom-TI Dr. Maya Silvi Lidya, B.Sc, M.Sc.\n" +
                    "This program consists of several activities that support cooperation with UUM, namely the Joint Research Colloquium for S2 / S3 students and lecturers from UUM and USU in the Seminar Room Building C and D Fasilkom-TI. Furthermore, a public lecture with the material Through the HCI-UX Lenses: Designing for Persons with Disabilities presented by Prof. Madya Dr. Husniza binti Husni in the Seminar Room Building E.",
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight(300),
                color = Color(0xFF000000),
                textAlign = TextAlign.Justify,)
        )
        Image(painter = painterResource(id = R.drawable.gambar4),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(335.dp)
                .height(180.dp)
        )

        Text(
            text = "In the public lecture, it was explained that there is a difference between universal design and inclusive design. Universal design is a design that is only made for all users, while inclusive design is a design that is customized and specific to a user. In designing applications, there are processes or stages that must be carried out, namely design thinking. Design thinking consists of five processes, namely, empathize, define, ideate, prototype, and test.\n" +
                    "Then, the activity continued with ishoma and eating together and ended with the handover of souvenirs from Fasilkom-TI to UUM and a group photo in the Seminar Room Building E Fasilkom-TI.",
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight(300),
                color = Color(0xFF000000),
                textAlign = TextAlign.Justify,)
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
    ReadMorePage2()
}
