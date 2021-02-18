package com.picpay.desafio.android.model.remote

import com.squareup.moshi.Json

data class UserRemote(
    @Json(name = "img") val img: String,
    @Json(name = "name") val name: String,
    @Json(name = "id") val id: Int,
    @Json(name = "username") val username: String
)
