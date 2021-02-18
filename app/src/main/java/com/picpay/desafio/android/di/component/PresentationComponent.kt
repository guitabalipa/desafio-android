package com.picpay.desafio.android.di.component

import com.picpay.desafio.android.MainActivity
import com.picpay.desafio.android.di.scope.PresentationScope
import dagger.Subcomponent

@PresentationScope
@Subcomponent
interface PresentationComponent {
    fun inject(activity: MainActivity)
}
