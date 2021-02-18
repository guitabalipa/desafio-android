package com.picpay.desafio.android.api

import com.picpay.desafio.android.model.remote.UserRemote
import retrofit2.Call
import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    fun getUsers(): Call<List<UserRemote>>
}
