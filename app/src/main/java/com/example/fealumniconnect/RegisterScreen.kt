package com.example.fealumniconnect

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fealumniconnect.ui.theme.Outline
import com.example.fealumniconnect.ui.theme.Poppins

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun RegisterScreen() {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var prodi by remember {
        mutableStateOf(value = "")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    )
    {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(
                            text = "Registrasi Akun",
                            fontFamily = Poppins,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized Description"
                            )
                        }
                    }
                )

            }
        )


        {

        }
    }


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 40.dp)
    )
    {
        Divider(
            thickness = 3.dp,
            color = Color.LightGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.logo_app),
            contentDescription = "",
            modifier = Modifier.size(160.dp)
        )
        Text(
            text = "Registrasi Akun",
            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
        )

        Text(
            text = "Buat akun disini",
            color = Color.Gray,
            fontFamily = Poppins,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp,
        )

        Text(
            text = "Program Studi",
            textAlign = TextAlign.Left,
            fontFamily = Poppins,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
                .padding(horizontal = 20.dp),
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
        )

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            OutlinedTextField(
                value = prodi,
                onValueChange = {},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Outline,
                    unfocusedBorderColor = Color.Black
                ),
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                modifier = Modifier
                    .padding(top = 5.dp)
                    .width(370.dp)
                    .height(50.dp)
                    .menuAnchor()

            )
            ExposedDropdownMenu(
                expanded = isExpanded ,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = "Ilmu Komputer")
                    },
                    onClick = {
                        prodi = "Ilmu Komputer"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(text = "Teknologi Informasi")
                    },
                    onClick = {
                        prodi = "Teknologi Informasi"
                        isExpanded = false
                    }
                )
            }
        }
    }
}