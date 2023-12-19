package com.example.fealumniconnect.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fealumniconnect.R
import com.example.fealumniconnect.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }

    Box(contentAlignment = Alignment.TopCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Selamat Datang !",
                fontSize = 26.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins
            )

//            val imageModifier = Modifier
//                .size(150.dp)
            Image(
                painter = painterResource(id = R.drawable.anim_login), contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.requiredSize(200.dp)
                    .fillMaxWidth()
                    .padding(top = 30.dp),

                )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .background(Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {

                Column(horizontalAlignment = Alignment.Start) {

                    Text(
                        text = "NIM",
                        color = SecondaryColor,
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                    )

                    OutlinedTextField(
                        value = username, onValueChange = {
                            username = it
                        },
                        label = {
                            Text(text = "NIM", color = SecondaryColor)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor

                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType =
                            KeyboardType.Number
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_user),
                                contentDescription = "",
                                tint = SecondaryColor,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    )

                    Text(
                        text = "Password",
                        color = SecondaryColor,
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp)
                    )


                    OutlinedTextField(
                        value = password, onValueChange = {
                            password = it
                        },
                        label = {
                            Text(text = "Password", color = SecondaryColor)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_password),
                                contentDescription = "",
                                tint = SecondaryColor,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                                if (!isPasswordOpen) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_eye_open),
                                        contentDescription = "",
                                        tint = SecondaryColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                } else {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_eye_close),
                                        contentDescription = "",
                                        tint = SecondaryColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }
                    )

                    Column(horizontalAlignment = Alignment.End)
                    {
                        TextButton(
                            onClick = {},
                            contentPadding = PaddingValues(vertical = 0.dp, horizontal = 20.dp)
                        ) {
                            Text(
                                text = "Lupa Password ? Klik disini",
                                color = LightTextColor,
                                fontFamily = Poppins,
                                fontSize = 12.sp,
                            )
                        }
                    }

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp)
                            .background(Color.White),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(vertical = 14.dp)
                    ) {

                        Text(text = "Login", fontFamily = Poppins)
                    }

                    Column(horizontalAlignment = Alignment.End)
                    {
                        TextButton(
                            onClick = {},
                            contentPadding = PaddingValues(vertical = 0.dp, horizontal = 20.dp)
                        ) {
                            Text(
                                text = "Tidak Punya Akun ? Buat Akun",
                                color = LightTextColor,
                                fontFamily = Poppins,
                                fontSize = 12.sp,
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}
