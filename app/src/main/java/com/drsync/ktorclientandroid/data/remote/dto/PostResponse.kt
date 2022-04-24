package com.drsync.ktorclientandroid.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class PostResponse(
    val body : String,
    val title: String,
    val id: Int,
    val userId: Int
) : Parcelable
