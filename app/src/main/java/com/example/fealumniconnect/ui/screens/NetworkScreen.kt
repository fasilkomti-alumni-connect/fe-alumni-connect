package com.example.fealumniconnect.ui.screens

//

// import androidx.compose.foundation.Image
import androidx.compose.foundation.background
// import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
// import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
// import androidx.compose.ui.graphics.Outline
// import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
// import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import com.example.fealumniconnect.R
import com.example.fealumniconnect.ui.theme.*
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NetworkScreen() {
    var nama by remember { mutableStateOf("") }
    var isNamaError by remember { mutableStateOf(false) }
    var angkatan by remember { mutableStateOf("") }
    var isAngkatanError by remember { mutableStateOf(false) }

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

                    Text(
                        text = "My Network",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinssemibold)
                            ),
                            // fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp)
                            .padding(bottom = 20.dp)
                    )
                }

            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color.LightGray)
                    .padding(bottom = 0.dp)
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.background)
            ){
                Column (horizontalAlignment = Alignment.Start){
                    Text(
                        text = "Cari Alumni",
                        color = SecondaryColor,
                        fontFamily = FontFamily(
                            Font(R.font.poppinssemibold)
                        ),
                        fontSize = 24.sp,
                        // fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 32.dp)
                    )
                    //header field nama
                    Text(
                        text = "Nama",
                        color = SecondaryColor,
                        fontFamily = FontFamily(
                            Font(R.font.poppinsmedium)
                        ),
                        fontSize = 12.sp,
                        // fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top=25.dp)
                    )
                    //field nama
                    OutlinedTextField(
                        value = nama,
                        onValueChange = {
                            nama = it
                            isNamaError = !isValidnama(it) // Validate nama tidak kosong
                        },
                        placeholder = {
                            Text(
                                text = "Nama",
                                color = SecondaryColor,
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                fontSize = 14.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor,
                            focusedLabelColor = if (isNamaError) Color.Red else SecondaryColor,
                            focusedBorderColor = if (isNamaError) Color.Red else SecondaryColor
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    if (isNamaError) {
                        Text(
                            text = "Please Enter A Name",
                            color = Color.Red,
                            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .padding(top = 4.dp)
                        )
                    }
                    //header field angkatan
                    Text(
                        text = "Angkatan",
                        color = SecondaryColor,
                        fontFamily = FontFamily(
                            Font(R.font.poppinsmedium)
                        ),
                        fontSize = 14.sp,
                        // fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top=25.dp)
                    )

                    //field angkatan
                    OutlinedTextField(
                        value = angkatan,
                        onValueChange = {
                            angkatan = it
                            isAngkatanError = !isValidangkatan(it) // Validate input angkatan
                        },
                        placeholder = {
                            Text(
                                text = "angkatan",
                                color = SecondaryColor,
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                fontSize = 12.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor,
                            focusedLabelColor = if (isAngkatanError) Color.Red else SecondaryColor,
                            focusedBorderColor = if (isAngkatanError) Color.Red else SecondaryColor
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    if (isAngkatanError) {
                        Text(
                            text = "Please Enter A Valid Year",
                            color = Color.Red,
                            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .padding(top = 4.dp)
                        )
                    }



                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 32.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = PrimaryColor
                        ),
                        contentPadding = PaddingValues(vertical = 18.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(
                            text = "Kirim",
                            fontFamily = FontFamily(
                                Font(R.font.poppinsbold)
                            ),
                            fontSize = 14.sp)
                        //fontWeight = FontWeight.Bold)
                    }







                }
            }
        }
    }
}

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
//        BottomNavItem(iconResId = R.drawable.ic_arrow, label = "", isSelected = false)
//        BottomNavItem(iconResId = R.drawable.ic_arrow, label = "", isSelected = false)
//        BottomNavItem(iconResId = R.drawable.ic_arrow, label = "", isSelected = false)
//        BottomNavItem(iconResId = R.drawable.ic_arrow, label = "", isSelected = false)
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

//validation untuk nama, jika kosong atau ada integer, ada warning
fun isValidnama(nama: String): Boolean {
    return nama.isNotEmpty() && !nama.any { it.isDigit()}
}
//validation untuk angkatan, jika kosong atau ada huruf dan panjang input kurang dari 4, ada warning
fun isValidangkatan(angkatan: String): Boolean {
    return angkatan.isNotEmpty() && angkatan.length == 4 && angkatan.all { it.isDigit() }
}