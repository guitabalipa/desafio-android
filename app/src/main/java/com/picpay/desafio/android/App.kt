package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.component.ApplicationComponent
import com.picpay.desafio.android.di.component.DaggerApplicationComponent
import timber.log.Timber

class App : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
