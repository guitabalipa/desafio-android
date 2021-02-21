package com.picpay.desafio.android.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.picpay.desafio.android.interactor.GetUsersInteractor
import com.picpay.desafio.android.model.domain.User
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getUsersInteractor: GetUsersInteractor

    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var usersObserver: Observer<List<User>>

    @Test
    fun `should return users from interactor`() = runBlocking {
        val users = listOf(User("test", "test", 1, "test"))

        doReturn(users)
            .`when`(getUsersInteractor).invoke()

        mainViewModel = MainViewModel(getUsersInteractor)
        mainViewModel.users.observeForever(usersObserver)
        verify(getUsersInteractor).invoke()
        verify(usersObserver).onChanged(users)
        mainViewModel.users.removeObserver(usersObserver)
    }
}
