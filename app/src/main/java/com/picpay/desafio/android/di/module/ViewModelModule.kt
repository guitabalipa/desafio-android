package com.picpay.desafio.android.di.module

import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.di.ViewModelKey
import com.picpay.desafio.android.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
