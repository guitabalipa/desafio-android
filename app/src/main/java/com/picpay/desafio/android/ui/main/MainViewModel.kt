package com.picpay.desafio.android.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.interactor.GetUsersInteractor
import com.picpay.desafio.android.model.domain.User
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getUsersInteractor: GetUsersInteractor
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>().apply { value = false }
    val loading: LiveData<Boolean> = _loading

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        _loading.value = true
        viewModelScope.launch {
            _users.value = getUsersInteractor()
            _loading.value = false
        }
    }
}
