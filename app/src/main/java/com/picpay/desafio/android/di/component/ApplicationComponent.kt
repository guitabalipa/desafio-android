package com.picpay.desafio.android.di.component

import android.app.Application
import com.picpay.desafio.android.di.module.InterceptorsModule
import com.picpay.desafio.android.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        InterceptorsModule::class
    ]
)
interface ApplicationComponent {
    fun activityComponentBuilder(): ActivityComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}
