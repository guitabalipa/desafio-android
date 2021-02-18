package com.picpay.desafio.android.model.mapper

import com.picpay.desafio.android.model.domain.User
import com.picpay.desafio.android.model.remote.UserRemote

fun UserRemote.toDomain(): User {
    return User(
        img = img,
        name = name,
        username = username,
        id = id
    )
}
