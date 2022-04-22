package com.drsync.ktorclientandroid.data.remote.screen

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.drsync.ktorclientandroid.data.remote.navigation.Screen

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navHostController.navigate(Screen.ListDataScreen.route)
            },
        ) {
            Text(text = "List Data")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navHostController.navigate(Screen.SendDataScreen.route)
            },
        ) {
            Text(text = "Send Data")
        }
    }
}