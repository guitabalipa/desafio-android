package com.picpay.desafio.android.model.mapper

import com.picpay.desafio.android.model.domain.User
import com.picpay.desafio.android.model.entity.UserEntity
import com.picpay.desafio.android.model.remote.UserRemote

fun UserRemote.toEntity(): UserEntity {
    return UserEntity(
        img = img,
        name = name,
        username = username,
        id = id
    )
}

fun UserEntity.toDomain(): User {
    return User(
        img = img,
        name = name,
        username = username,
        id = id
    )
}
