package com.picpay.desafio.android.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.model.domain.User
import com.picpay.desafio.android.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        setupObservables()
    }

    private fun setupViews() {
        with(binding) {
            adapter = UserListAdapter()
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupObservables() {
        viewModel.loading.observe(this, ::renderLoading)
        viewModel.users.observe(this, ::renderUsers)
    }

    private fun renderLoading(isLoading: Boolean) {
        binding.userListProgressBar.isVisible = isLoading
    }

    private fun renderUsers(users: List<User>) {
        adapter.users = users
    }
}
