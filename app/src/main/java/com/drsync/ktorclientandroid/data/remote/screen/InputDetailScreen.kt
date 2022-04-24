package com.drsync.ktorclientandroid.data.remote.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.drsync.ktorclientandroid.data.remote.dto.PostResponse

@Composable
fun InputDetailScreen(
    navHostController: NavHostController
) {
    val result =
        navHostController.previousBackStackEntry?.savedStateHandle?.get<PostResponse>("post")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "UserId :")
            Text(
                text = result?.userId.toString(),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Id :")
            Text(
                text = result?.id.toString(),
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = result?.title.toString(),
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = result?.body.toString())
    }
}