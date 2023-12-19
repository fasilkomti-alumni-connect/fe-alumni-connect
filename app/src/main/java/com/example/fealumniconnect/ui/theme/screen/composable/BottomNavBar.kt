package com.example.fealumniconnect.ui.theme.screen.composable

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fealumniconnect.R

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(iconResId = R.drawable.ic_home, label = "", isSelected = false)
        BottomNavItem(iconResId = R.drawable.ic_calendar, label = "", isSelected = false)
        BottomNavItem(iconResId = R.drawable.ic_globe, label = "", isSelected = false)
        BottomNavItem(iconResId = R.drawable.ic_user, label = "", isSelected = false)
    }
}
@Composable
fun BottomNavItem(@DrawableRes iconResId: Int, label: String, isSelected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { /* Handle navigation here */ }
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            colorFilter = ColorFilter.tint(if (isSelected) Color.White else Color.Gray),
            modifier = Modifier.size(30.dp)
        )
    }
}