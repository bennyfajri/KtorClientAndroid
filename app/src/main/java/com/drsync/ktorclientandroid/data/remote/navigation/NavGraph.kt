package com.drsync.ktorclientandroid.data.remote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.drsync.ktorclientandroid.data.remote.screen.HomeScreen
import com.drsync.ktorclientandroid.data.remote.screen.InputDetailScreen
import com.drsync.ktorclientandroid.data.remote.screen.ListDataScreen
import com.drsync.ktorclientandroid.data.remote.screen.SendDataScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navHostController = navHostController)
        }
        composable(route = Screen.ListDataScreen.route) {
            ListDataScreen()
        }
        composable(route = Screen.SendDataScreen.route) {
            SendDataScreen(navHostController = navHostController)
        }
        composable(route = Screen.InputDetailScreen.route) {
            InputDetailScreen()
        }
    }
}