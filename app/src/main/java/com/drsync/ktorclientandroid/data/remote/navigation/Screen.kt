package com.drsync.ktorclientandroid.data.remote.navigation

sealed class Screen (val route: String) {
    object HomeScreen : Screen("HomeScreen")
    object ListDataScreen: Screen("GetData")
    object SendDataScreen : Screen("SendData")
    object InputDetailScreen : Screen("InputDetail")
}
