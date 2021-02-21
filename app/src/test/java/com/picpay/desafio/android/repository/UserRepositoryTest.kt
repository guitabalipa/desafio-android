package com.picpay.desafio.android.repository

import com.picpay.desafio.android.api.PicPayService
import com.picpay.desafio.android.datasource.db.dao.UserDao
import com.picpay.desafio.android.model.entity.UserEntity
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRepositoryTest {

    @Mock
    private lateinit var service: PicPayService

    @Mock
    private lateinit var userDao: UserDao

    private lateinit var userRepository: UserRepository

    @Before
    fun setup() {
        userRepository = UserRepository(service, userDao)
    }

    @Test
    fun `should return users from database`() = runBlocking {
        val users = listOf(
            UserEntity(1, "test", "test", "test")
        )

        doReturn(users).`when`(userDao).getAll()

        val result = userRepository.getUsers()

        assertNotNull(result)
        assertEquals(result, users)
    }
}
