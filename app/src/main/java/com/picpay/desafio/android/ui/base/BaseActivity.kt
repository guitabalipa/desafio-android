package com.picpay.desafio.android.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.picpay.desafio.android.App
import com.picpay.desafio.android.ui.viewmodel.ViewModelFactory
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val appComponent get() = (application as App).appComponent

    val activityComponent by lazy {
        appComponent.activityComponentBuilder()
            .activity(this)
            .build()
    }

    private val presentationComponent by lazy {
        activityComponent.presentationComponent()
    }

    protected val injector get() = presentationComponent
}
