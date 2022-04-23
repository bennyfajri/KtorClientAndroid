package com.drsync.ktorclientandroid.data.remote.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.drsync.ktorclientandroid.data.remote.PostService
import com.drsync.ktorclientandroid.data.remote.dto.PostRequest
import com.drsync.ktorclientandroid.data.remote.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SendDataScreen(
    navHostController: NavHostController
) {
    val service = PostService.create()

    var userIdState by remember {
        mutableStateOf("")
    }
    var titleState by remember {
        mutableStateOf("")
    }
    var bodyState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(
            value = userIdState,
            onValueChange = {
                userIdState = it
            },
            label = {
                Text(text = "UserId")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = titleState,
            onValueChange = {
                titleState = it
            },
            label = {
                Text(text = "Title")
            },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = bodyState,
            onValueChange = {
                bodyState = it
            },
            label = {
                Text(text = "Body")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val postRequest = PostRequest(
                    userId = userIdState.toInt(),
                    title = titleState,
                    body = bodyState
                )
                scope.launch {
                    service.createPost(postRequest)
                    Toast.makeText(context, "Berhasil Input Data", Toast.LENGTH_SHORT)
                        .show()
                    delay(2500)
                }
//                navHostController.navigate(Screen.InputDetailScreen.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Kirim data")
        }
    }
}