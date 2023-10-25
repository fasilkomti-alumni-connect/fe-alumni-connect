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



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ForgotPasswordScreen() {
    var email by remember { mutableStateOf("") }
    var isEmailError by remember { mutableStateOf(false) }

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
                        text = "Lupa Password",
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
                        text = "Enter Your Password",
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

                    Text(
                        text = "Kode akan dikirim dalam bentuk pesan dan nomor verifikasi 6-digit",
                        color = LightTextColor,
                        fontFamily = FontFamily(
                            Font(R.font.poppinsmedium)
                        ),
                        fontSize = 12.sp,
                        // fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .padding(top = 2.dp)
                            .width(328.dp)
                            .height(36.dp),
                        lineHeight = 16.sp
                    )


                    Text(
                        text = "Email",
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

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            isEmailError = !isValidEmail(it) // Validate email format
                        },
                        placeholder = {
                            Text(
                                text = "E-mail..",
                                color = SecondaryColor,
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                fontSize = 14.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 15.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor,
                            focusedLabelColor = if (isEmailError) Color.Red else SecondaryColor,
                            focusedBorderColor = if (isEmailError) Color.Red else SecondaryColor
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    if (isEmailError) {
                        Text(
                            text = "Please enter a valid email",
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

fun isValidEmail(email: String): Boolean {
    val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return email.matches(emailRegex.toRegex())
}