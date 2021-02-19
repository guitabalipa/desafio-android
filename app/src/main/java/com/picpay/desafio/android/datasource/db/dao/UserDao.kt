package com.picpay.desafio.android.datasource.db.dao

import androidx.room.*
import com.picpay.desafio.android.model.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>
}
