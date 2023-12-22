package com.example.fealumniconnect.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fealumniconnect.HomeScreen
import com.example.fealumniconnect.ui.screens.CalendarScreen
import com.example.fealumniconnect.ui.screens.EventScreen
import com.example.fealumniconnect.ui.screens.NetworkScreen
import com.example.fealumniconnect.ui.theme.screen.EditProfile
import com.example.fealumniconnect.ui.theme.screen.Profile

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(){
    val navController : NavHostController = rememberNavController()

    Scaffold (
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItems.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = navItem.icon),
                                contentDescription = null,
//                                colorFilter = ColorFilter.tint(if (isSelected) Color.White else Color.Gray),
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues: PaddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screens.HomeScreen.name){
                HomeScreen()
            }
            composable(route = Screens.EventScreen.name){
                EventScreen()
            }
            composable(route = Screens.CalendarScreen.name){
                CalendarScreen(navController = navController)
            }
            composable(route = Screens.NetworkScreen.name){
                NetworkScreen()
            }
            composable(route = Screens.ProfileScreen.name){
                Profile(navController = navController)
            }
            composable(route = Screens.EditProfileScreen.name){
                EditProfile(navController = navController)
            }
        }

    }
}