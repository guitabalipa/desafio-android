package com.picpay.desafio.android.repository

import com.picpay.desafio.android.api.PicPayService
import com.picpay.desafio.android.datasource.db.dao.UserDao
import com.picpay.desafio.android.model.entity.UserEntity
import com.picpay.desafio.android.model.mapper.toEntity
import timber.log.Timber
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val service: PicPayService,
    private val userDao: UserDao
) {

    suspend fun getUsers(): List<UserEntity> {
        try {
            val users = service.getUsers().map { it.toEntity() }
            userDao.insertAll(users)
        } catch (e: Exception) {
            Timber.e(e)
        }
        return userDao.getAll()
    }
}
