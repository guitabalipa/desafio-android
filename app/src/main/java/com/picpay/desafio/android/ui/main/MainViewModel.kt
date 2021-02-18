package com.picpay.desafio.android.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.interactor.GetUsersInteractor
import com.picpay.desafio.android.model.domain.User
import com.picpay.desafio.android.ui.base.SingleLiveEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getUsersInteractor: GetUsersInteractor
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>().apply { value = false }
    val loading: LiveData<Boolean> = _loading

    private val _content = MutableLiveData<Boolean>().apply { value = false }
    val content: LiveData<Boolean> = _content

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    val error = SingleLiveEvent<Boolean>()

    init {
        getUsers()
    }

    private fun getUsers() {
        _loading.value = true
        viewModelScope.launch {
            try {
                _users.value = getUsersInteractor()
                _content.value = true
            } catch (e: Exception) {
                _content.value = false
                error.value = true
            } finally {
                _loading.value = false
            }
        }
    }
}
