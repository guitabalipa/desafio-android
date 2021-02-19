package com.picpay.desafio.android.interactor

import com.picpay.desafio.android.model.domain.User
import com.picpay.desafio.android.model.mapper.toDomain
import com.picpay.desafio.android.repository.UserRepository
import javax.inject.Inject

class GetUsersInteractor @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(): List<User> {
        return repository.getUsers().map { it.toDomain() }
    }
}
