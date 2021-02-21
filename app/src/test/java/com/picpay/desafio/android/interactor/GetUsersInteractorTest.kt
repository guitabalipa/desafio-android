package com.picpay.desafio.android.interactor

import com.picpay.desafio.android.model.entity.UserEntity
import com.picpay.desafio.android.repository.UserRepository
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
class GetUsersInteractorTest {

    @Mock
    private lateinit var userRepository: UserRepository

    private lateinit var getUsersInteractor: GetUsersInteractor

    @Before
    fun setup() {
        getUsersInteractor = GetUsersInteractor(userRepository)
    }

    @Test
    fun `should return users from repository`() = runBlocking {
        val users = listOf(
            UserEntity(1, "test", "test", "test")
        )

        doReturn(users).`when`(userRepository).getUsers()

        val result = getUsersInteractor()

        assertNotNull(result)
        assertEquals(result[0].name, users[0].name)
        assertEquals(result[0].id, users[0].id)
        assertEquals(result[0].username, users[0].username)
        assertEquals(result[0].img, users[0].img)
    }
}
