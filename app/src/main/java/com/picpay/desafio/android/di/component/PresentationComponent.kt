package com.picpay.desafio.android.di.component

import com.picpay.desafio.android.di.module.ViewModelModule
import com.picpay.desafio.android.di.scope.PresentationScope
import com.picpay.desafio.android.ui.main.MainActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [ViewModelModule::class])
interface PresentationComponent {
    fun inject(activity: MainActivity)
}
