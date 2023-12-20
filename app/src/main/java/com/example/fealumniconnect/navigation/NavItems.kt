package com.example.fealumniconnect.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.fealumniconnect.R

data class NavItems(
    val label: String,
    val icon: Int,
    val route: String
)

val listOfNavItems = listOf(
    NavItems(
        label = "Home",
        icon = R.drawable.home,
        route = Screens.HomeScreen.name
    ),
    NavItems(
        label = "Event",
        icon = R.drawable.calendar,
        route = Screens.EventScreen.name
    ),
    NavItems(
        label = "Network",
        icon = R.drawable.globe,
        route = Screens.NetworkScreen.name
    ),
    NavItems(
        label = "Profile",
        icon = R.drawable.user,
        route = Screens.ProfileScreen.name
    )
)
