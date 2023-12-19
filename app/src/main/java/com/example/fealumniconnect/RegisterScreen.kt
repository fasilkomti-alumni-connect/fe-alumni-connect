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

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@ExperimentalMaterial3Api
//@Composable
//fun RegisterScreen() {
//    var isExpanded by remember {
//        mutableStateOf(false)
//    }
//    var prodi by remember {
//        mutableStateOf(value = "")
//    }
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//    )
//    {
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    colors = TopAppBarDefaults.smallTopAppBarColors(
//                        containerColor = MaterialTheme.colorScheme.background,
//                        titleContentColor = MaterialTheme.colorScheme.primary,
//                    ),
//                    title = {
//                        Text(
//                            text = "Registrasi Akun",
//                            fontFamily = Poppins,
//                            color = Color.Black,
//                            fontWeight = FontWeight.SemiBold,
//                            fontSize = 20.sp
//                        )
//                    },
//                    navigationIcon = {
//                        IconButton(onClick = { /*TODO*/ }) {
//                            Icon(
//                                imageVector = Icons.Filled.ArrowBack,
//                                contentDescription = "Localized Description"
//                            )
//                        }
//                    }
//                )
//
//            }
//        )
//
//
//        {
//
//        }
//    }
//
//
//    Column (
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .padding(top = 40.dp)
//    )
//    {
//        Divider(
//            thickness = 3.dp,
//            color = Color.LightGray,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(20.dp)
//        )
//        Image(
//            painter = painterResource(id = R.drawable.logo_app),
//            contentDescription = "",
//            modifier = Modifier.size(160.dp)
//        )
//        Text(
//            text = "Registrasi Akun",
//            textAlign = TextAlign.Left,
//            fontFamily = Poppins,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 10.dp)
//                .padding(horizontal = 20.dp),
//            fontWeight = FontWeight.ExtraBold,
//            fontSize = 20.sp,
//        )
//
//        Text(
//            text = "Buat akun disini",
//            color = Color.Gray,
//            fontFamily = Poppins,
//            textAlign = TextAlign.Left,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 20.dp),
//            fontWeight = FontWeight.SemiBold,
//            fontSize = 13.sp,
//        )
//
//        Text(
//            text = "Program Studi",
//            textAlign = TextAlign.Left,
//            fontFamily = Poppins,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 18.dp)
//                .padding(horizontal = 20.dp),
//            fontWeight = FontWeight.Normal,
//            fontSize = 15.sp,
//        )
//
//        ExposedDropdownMenuBox(
//            expanded = isExpanded,
//            onExpandedChange = { isExpanded = it }
//        ) {
//            OutlinedTextField(
//                value = prodi,
//                onValueChange = {},
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Outline,
//                    unfocusedBorderColor = Color.Black
//                ),
//                readOnly = true,
//                trailingIcon = {
//                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
//                },
//                modifier = Modifier
//                    .padding(top = 5.dp)
//                    .width(370.dp)
//                    .height(50.dp)
//                    .menuAnchor()
//
//            )
//            ExposedDropdownMenu(
//                expanded = isExpanded ,
//                onDismissRequest = { isExpanded = false }
//            ) {
//                DropdownMenuItem(
//                    text = {
//                        Text(text = "Ilmu Komputer")
//                    },
//                    onClick = {
//                        prodi = "Ilmu Komputer"
//                        isExpanded = false
//                    }
//                )
//                DropdownMenuItem(
//                    text = {
//                        Text(text = "Teknologi Informasi")
//                    },
//                    onClick = {
//                        prodi = "Teknologi Informasi"
//                        isExpanded = false
//                    }
//                )
//            }
//        }
//    }
//}

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