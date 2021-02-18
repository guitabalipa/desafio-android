package com.picpay.desafio.android.interactor

import com.picpay.desafio.android.api.PicPayService
import com.picpay.desafio.android.model.domain.User
import com.picpay.desafio.android.model.mapper.toDomain
import javax.inject.Inject

class GetUsersInteractor @Inject constructor(private val service: PicPayService) {

    suspend operator fun invoke(): List<User> {
        return service.getUsers().map { it.toDomain() }
    }
}
