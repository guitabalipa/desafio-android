package com.picpay.desafio.android.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.datasource.db.dao.UserDao
import com.picpay.desafio.android.model.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
