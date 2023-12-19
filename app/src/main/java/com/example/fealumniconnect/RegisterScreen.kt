package com.example.fealumniconnect.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fealumniconnect.R
import com.example.fealumniconnect.ui.theme.PrimaryColor
import com.example.fealumniconnect.ui.theme.SecondaryColor
import com.example.fealumniconnect.ui.theme.dropdownSelected

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Preview
@Composable
fun RegisterScreen() {
    //    var isExpanded by remember {
//        mutableStateOf(false)
//    }
//    var prodi by remember {
//        mutableStateOf(value = "")
//    }

    val context = LocalContext.current
    val programStudi = arrayOf("Pilih Program Studi","S-1 Teknologi Informasi", "S-1 Ilmu Komputer", "S-2 Teknik Informatika","S-2 Sains Data dan Kecerdasan Buatan","S-3 Ilmu Komputer")
    var expanded by remember { mutableStateOf(false) }
    var selectedProgramStudi by remember { mutableStateOf(programStudi[0]) }

    val tahunMasuk = arrayOf("Pilih Tahun Masuk","2023", "2022","2021","2020")
    var expandedTahunMasuk by remember { mutableStateOf(false) }
    var selectedTahunMasuk by remember { mutableStateOf(tahunMasuk[0]) }

    var nim by remember { mutableStateOf("") }
    var isNimError by remember { mutableStateOf(false) }

    var name by remember { mutableStateOf("") }
    var isNameError by remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var isEmailError by remember { mutableStateOf(false) }

    var password by remember { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }

    var confirmPassword by remember { mutableStateOf("") }

    var isConfirmPasswordOpen by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    // Function to check if passwords match
    fun doPasswordsMatch(): Boolean {
        return password == confirmPassword
    }

    // Text for displaying the error message
    val errorMessage = if (passwordError) {
        "Passwords do not match"
    } else {
        ""
    }

    Box{
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().background(Color.White)
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)
                    .background(Color.White)
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
                        modifier = Modifier
                            .size(25.dp)
                            .padding(top = 5.dp)
                    )

                    Text(
                        text = "Registrasi Akun",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinssemibold)
                            ),
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
        }

    }

    LazyColumn(modifier = Modifier.padding(top=80.dp).fillMaxSize()){
        item {
            Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.background(MaterialTheme.colorScheme.background)){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ){


                    Image(
                        painter = painterResource(id = R.drawable.logo_app),
                        contentDescription = "",
                        modifier = Modifier
                            .size(160.dp)
                            .padding(top = 10.dp)
                    )

                    Text(
                        text = "Registrasi Akun",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinssemibold)
                            ),
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                            .padding(horizontal = 20.dp)
                    )

                    Text(
                        text = "Buat akun disini",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinsmedium)
                            ),
                            color = Color.LightGray
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 0.dp)
                            .padding(horizontal = 20.dp)
                    )

                    Text(
                        text = "Program Studi",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinsmedium)
                            ),
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp)
                            .padding(horizontal = 20.dp)
                    )


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(horizontal = 20.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .border(1.dp, SecondaryColor, shape = MaterialTheme.shapes.small)
                                .height(55.dp)
                                .padding(10.dp)
                                .padding(top = 7.dp)
                                .padding(bottom = 7.dp)
                        ) {
                            Text(
                                text = selectedProgramStudi,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(
                                        Font(R.font.poppins)
                                    ),
                                    color = Color.Black
                                ),
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = rememberRipple(bounded = false)
                                    ) {
                                        expanded = !expanded
                                    }
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = rememberRipple(bounded = false)
                                    ) {
                                        expanded = !expanded
                                    }
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                        ){
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ){
                                DropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false },
                                    modifier = Modifier
                                        .width(350.dp)
                                        .padding(start = 5.dp)
                                        .padding(end = 5.dp),


                                    ) {
                                    programStudi.forEach { item ->
                                        val isSelected = item == selectedProgramStudi
                                        val backgroundColor = if (isSelected) dropdownSelected // Change to your desired color
                                        else Color.Transparent
                                        DropdownMenuItem(
                                            //text = { Text(text = item)},
                                            text = {
                                                Text(
                                                    text = item,
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        fontFamily = FontFamily(Font(R.font.poppins))
                                                    )
                                                )
                                            },

                                            onClick = {
                                                selectedProgramStudi = item
                                                expanded = false
                                                Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                            },
                                            modifier = Modifier.background(backgroundColor)
                                        )
                                    }
                                }
                            }
                        }
                    }


                    Text(
                        text = "Tahun Masuk",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinsmedium)
                            ),
                            // fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp)
                            .padding(horizontal = 20.dp)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight() // Mengisi seluruh tinggi
                            .padding(horizontal = 20.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .border(1.dp, SecondaryColor, shape = MaterialTheme.shapes.small)
                                .height(55.dp)
                                .padding(10.dp)
                                .padding(top = 7.dp)
                                .padding(bottom = 7.dp)
                        ) {
                            Text(
                                text = selectedTahunMasuk,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(
                                        Font(R.font.poppins)
                                    ),
                                    // fontWeight = FontWeight.SemiBold,
                                    color = Color.Black
                                ),
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = rememberRipple(bounded = false)
                                    ) {
                                        expandedTahunMasuk = !expandedTahunMasuk
                                    }
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = rememberRipple(bounded = false)
                                    ) {
                                        expandedTahunMasuk = !expandedTahunMasuk
                                    }
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            //.padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.Center,
                        ){
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                //.padding(horizontal = 20.dp)
                            ){
                                DropdownMenu(
                                    expanded = expandedTahunMasuk,
                                    onDismissRequest = { expandedTahunMasuk = false },
                                    modifier = Modifier
                                        .width(350.dp)
                                        .padding(start = 5.dp)
                                        .padding(end = 5.dp),
                                ) {
                                    tahunMasuk.forEach { item ->
                                        val isSelected = item == selectedTahunMasuk
                                        val backgroundColor = if (isSelected) dropdownSelected
                                        else Color.Transparent
                                        DropdownMenuItem(
                                            text = {
                                                Text(
                                                    text = item,
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        fontFamily = FontFamily(Font(R.font.poppins))
                                                    )
                                                )
                                            },
                                            //text = { Text(text = item) },
                                            onClick = {
                                                selectedTahunMasuk = item
                                                expandedTahunMasuk = false
                                                Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                            },
                                            modifier = Modifier.background(backgroundColor)
                                        )
                                    }
                                }
                            }
                        }
                    }






                    Text(
                        text = "NIM",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinsmedium)
                            ),
                            // fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp)
                            .padding(horizontal = 20.dp)
                    )

                    OutlinedTextField(
                        value = nim,
                        onValueChange = {
                            nim = it
                            isNimError = !isValidNim(it) // Validate NIM format
                        },
                        placeholder = {
                            Text(
                                text="NIM",
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                fontSize = 14.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 0.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor,
                            focusedLabelColor = if (isNimError) Color.Red else SecondaryColor,
                            focusedBorderColor = if (isNimError) Color.Red else SecondaryColor
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    if (isNimError) {
                        Text(
                            textAlign = TextAlign.Start,
                            text = "Please enter a valid NIM (numeric format)",color = Color.Red,
                            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .padding(top = 4.dp)
                                .fillMaxWidth()

                        )
                    }

                    Text(
                        text = "Nama",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinsmedium)
                            ),
                            // fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp)
                            .padding(horizontal = 20.dp)
                    )

                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
                            isNameError = !isValidName(it) // Validate name format
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
                            .padding(top = 0.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor,
                            focusedLabelColor = if (isNameError) Color.Red else SecondaryColor,
                            focusedBorderColor = if (isNameError) Color.Red else SecondaryColor
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    if (isNameError) {
                        Text(
                            text = "Please enter a valid name",
                            color = Color.Red,
                            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }

                    Text(
                        text = "Email",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinsmedium)
                            ),
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp)
                            .padding(horizontal = 20.dp)
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                            isEmailError = !isValidEmail(it)
                        },
                        placeholder = {
                            Text(
                                text = "E-mail",
                                color = SecondaryColor,
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                fontSize = 14.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 0.dp),
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
                                .fillMaxWidth()
                        )
                    }


                    Text(
                        text = "Password",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                Font(R.font.poppinsmedium)
                            ),
                            // fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp)
                            .padding(horizontal = 20.dp)
                    )

                    OutlinedTextField(
                        value = password, onValueChange = {
                            password = it
                            passwordError = !doPasswordsMatch()
                        },
                        placeholder = {
                            Text(
                                text = "Password",
                                color = SecondaryColor,
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                fontSize = 14.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 0.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor
                        ),
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
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


                    Text(
                        text = "Konfirmasi Password", // Change the label
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp)
                            .padding(horizontal = 20.dp)
                    )

                    OutlinedTextField(
                        value = confirmPassword, // Use a different variable for confirmation
                        onValueChange = {
                            confirmPassword = it
                            passwordError = !doPasswordsMatch()
                        },
                        placeholder = {
                            Text(
                                text = "Konfirmasi Password",
                                color = SecondaryColor,
                                fontFamily = FontFamily(Font(R.font.poppins)),
                                fontSize = 14.sp
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 0.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = SecondaryColor,
                            textColor = SecondaryColor
                        ),
                        shape = RoundedCornerShape(10.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        visualTransformation = if (!isConfirmPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
                        trailingIcon = {
                            IconButton(onClick = { isConfirmPasswordOpen = !isConfirmPasswordOpen }) {
                                if (!isConfirmPasswordOpen) {
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

                    //confirm password
                    // Error message for Confirm Password
                    Text(
                        text = errorMessage,
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppinsmedium)),
                            color = Color.Red
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                            .padding(horizontal = 20.dp)
                    )

                    //button
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(bottom = 30.dp)
                            .padding(top = 10.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = PrimaryColor
                        ),
                        contentPadding = PaddingValues(vertical = 18.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(
                            text = "Register",
                            fontFamily = FontFamily(
                                Font(R.font.poppinsbold)
                            ),
                            fontSize = 14.sp)
                    }


                }
            }
        }
    }
}

fun isValidNim(nim: String): Boolean {
    return nim.matches(Regex("\\d+"))
}

fun isValidName(name: String): Boolean {
    // Regular expression pattern for a valid name (letters and spaces only)
    val regexPattern = Regex("^[A-Za-z ]+\$")
    return regexPattern.matches(name)
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return email.matches(emailRegex.toRegex())
}
