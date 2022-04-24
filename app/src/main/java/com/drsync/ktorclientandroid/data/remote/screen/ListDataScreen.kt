package com.drsync.ktorclientandroid.data.remote.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.drsync.ktorclientandroid.data.remote.PostService
import com.drsync.ktorclientandroid.data.remote.dto.PostResponse
import com.drsync.ktorclientandroid.ui.theme.KtorClientAndroidTheme

@Composable
fun ListDataScreen() {
    val service = PostService.create()

    val posts = produceState<List<PostResponse>>(
        initialValue = emptyList(),
        producer = {
            value = service.getPosts()
        }
    )
    KtorClientAndroidTheme {
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn {
                items(posts.value) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = it.title, fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.body, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}