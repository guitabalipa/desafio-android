package com.picpay.desafio.android.model.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRemote(
    val img: String,
    val name: String,
    val id: Int,
    val username: String
)
