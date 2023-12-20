
package com.example.fealumniconnect.ui.theme.screen

import Header
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fealumniconnect.R


@Composable
fun EditProfile(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(title = "Edit Profil")

        // Background image and user information
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .width(428.dp)
                .height(210.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.gedung),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(428.dp)
                    .height(210.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(align = Alignment.Top)
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.weight(1f))
                EditIcon(iconResId = R.drawable.ic_change, isSelected = false)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(46.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fotoprofil),
                    contentDescription = "Foto Profile",
                    modifier = Modifier.size(114.dp)
                )

            }

        }

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Column ( modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
            ){
                // Add some spacing between menu items and Logout button
                Spacer(modifier = Modifier.height(24.dp))

                // Form fields
                FormProfile(title = "Username", text = "username123")
                FormProfile(title = "Nama Depan", text = "Nama Depan")
                FormProfile(title = "Nama Belakang", text = "Nama Belakang")
                FormProfile(title = "Jenis Kelamin", text = "Pilih")
                FormProfile(title = "Tanggal lahir", text = "DD/MM/YYYY")
                FormProfile(title = "No HP", text = "Masukkan No HP")
                FormProfile(title = "Link Linkedin", text = "Masukkan link")
                FormProfile(title = "Link Github/Portofolio", text = "Masukkan link")
                FormProfile(title = "Ubah Password", text = "Masukkan password baru")

                // Add some spacing between menu items and Logout button
                Spacer(modifier = Modifier.height(80.dp))

                // Save button
                Button(
                    onClick = { /* Handle save */ },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff7aa764)),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    modifier = Modifier
//                        .fillMaxWidth()
                        .width(380.dp)
                        .height(55.dp)
                ) {
                    Text(
                        text = "Simpan",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .weight(1f) // Occupy remaining space
                    )
                }
            }
        }
    }
}

@Composable
fun EditIcon(@DrawableRes iconResId: Int, isSelected: Boolean) {
    val iconColor = if (isSelected) Color.White else Color.Gray

    Box(
        modifier = Modifier
            .background(
                color = Color(0xff7aa764),
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


@Composable
fun FormProfile(modifier: Modifier = Modifier, title: String, text: String,) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = title,
            color = Color.Black,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .border(
                    border = BorderStroke(1.dp, Color(0xffbcbcbc)),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(vertical = 4.dp)
                .height(57.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 10.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
            ) {
                Text(
                    text = text,
                    color = Color(0xFFBCBCBC),
                    style = TextStyle(
                        fontSize = 14.sp
                    ), // Occupy remaining space
                )

            }
        }
    }
}

@Preview(widthDp = 428, heightDp = 1442)
@Composable
private fun EditProfilPreview() {
//    EditProfile(navController = navController)
}
