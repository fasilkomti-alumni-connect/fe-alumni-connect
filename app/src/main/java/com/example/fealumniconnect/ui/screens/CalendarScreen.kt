package com.example.fealumniconnect.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.TextStyle.FULL
import java.util.Locale

import com.example.fealumniconnect.ui.screens.EventScreen
import com.example.fealumniconnect.R
import com.example.fealumniconnect.navigation.Screens
import com.example.fealumniconnect.ui.theme.PrimaryColor



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarScreen(navController: NavController) {
    val today = LocalDate.now()
    val currentMonth = today.month.getDisplayName(FULL, Locale.getDefault())
    val currentYear = today.year
    // Variabel untuk menyimpan bulan dan tahun yang ditampilkan
    var displayedMonthYear by remember { mutableStateOf(today) }
//
    Box(contentAlignment = Alignment.TopCenter) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Spacer added here

                    Text(
                        text = "Calendar",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinssemibold)
                            ),
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 12.dp) // Adjusted padding
                            .padding(bottom = 20.dp)
                    )
                }
            }
            // Blok UI
            Box(contentAlignment = Alignment.TopCenter) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Header dengan tombol Previous dan Next
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                        ) {
                            // Tombol Previous untuk mengurangi bulan
                            IconButton(
                                onClick = {
                                    displayedMonthYear = displayedMonthYear.minusMonths(1)
                                },
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(8.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrow),
                                    contentDescription = null,
                                    tint = Color.Black,
                                    modifier = Modifier.size(25.dp)
                                )
                            }

                            // Spacer untuk jarak
                            Spacer(modifier = Modifier.width(8.dp))

                            // Text menampilkan bulan dan tahun
                            Text(
                                text = "${displayedMonthYear.month.getDisplayName(FULL, Locale.getDefault())} ${displayedMonthYear.year}",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppinssemibold)),
                                    color = Color.Black
                                ),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 12.dp)
                                    .padding(bottom = 20.dp)
                            )

                            // Tombol Next untuk menambah bulan
                            IconButton(
                                onClick = {
                                    displayedMonthYear = displayedMonthYear.plusMonths(1)
                                },
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(8.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrow),
                                    contentDescription = null,
                                    tint = Color.Black,
                                    modifier = Modifier.size(25.dp).rotate(180f)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Menampilkan hari-hari dalam seminggu
                    val daysOfWeek = listOf("S", "M", "T", "W", "T", "F", "S")
                    Row(modifier = Modifier.fillMaxWidth()) {
                        daysOfWeek.forEach { day ->
                            Box(
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(40.dp)
                                    .align(Alignment.CenterVertically),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = day, style = TextStyle(fontSize = 14.sp))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Menampilkan tanggal dalam grid
                    val firstDayOfMonth = displayedMonthYear.withDayOfMonth(1)
                    val startIndex = firstDayOfMonth.dayOfWeek.value - 1
                    val endIndex = firstDayOfMonth.plusMonths(1).minusDays(1).dayOfMonth

                    val monthDays = (1..endIndex).toMutableList()
                    while (monthDays.size < 35) {
                        monthDays.add(0, 0)
                    }

                    val daysInRows = monthDays.chunked(7)

                    Column {
                        daysInRows.forEach { week ->
                            Row(modifier = Modifier.fillMaxWidth()) {
                                week.forEach { day ->
                                    if (day == 0) {
                                        Spacer(modifier = Modifier.width(40.dp).height(40.dp))
                                    } else {
                                        // Menampilkan kotak dengan tanggal
                                        val backgroundColor =
                                            if (day == today.dayOfMonth && displayedMonthYear == today) Color.Green else Color.White
                                        val textColor =
                                            if (day == today.dayOfMonth && displayedMonthYear == today) Color.White else Color.Black

                                        Box(
                                            modifier = Modifier
                                                .width(40.dp)
                                                .height(40.dp)
                                                .background(backgroundColor, shape = RoundedCornerShape(4.dp))
                                                .align(Alignment.CenterVertically),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = day.toString(),
                                                style = TextStyle(fontSize = 14.sp, color = textColor)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Box(contentAlignment = Alignment.TopCenter) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            // ... (Kode yang sudah ada untuk menampilkan kalender)

                            // Spacer tambahan setelah kalender
                            Spacer(modifier = Modifier.weight(1f))

                            // Tombol "Buat Event" untuk pindah ke halaman yang dituju
                            Button(
                                onClick = {
                                    // Handle klik tombol "Buat Event" di sini (tambahkan logika navigasi ke halaman yang diinginkan)
                                    // Contoh:
                                    navController.navigate(Screens.EventScreen.name)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.White,
                                    containerColor = PrimaryColor
                                ),
                                contentPadding = PaddingValues(vertical = 16.dp),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    text = "Buat Event",
                                    fontFamily = FontFamily(Font(R.font.poppinsbold)),
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}