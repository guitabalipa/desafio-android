package com.picpay.desafio.android.di.module

import android.app.Application
import androidx.room.Room
import com.picpay.desafio.android.datasource.db.AppDatabase
import com.picpay.desafio.android.datasource.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): AppDatabase {
        val databaseBuilder = Room.databaseBuilder(application, AppDatabase::class.java, "app.db")
        return databaseBuilder
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }
}
