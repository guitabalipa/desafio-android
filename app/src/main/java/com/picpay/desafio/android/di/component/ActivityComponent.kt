package com.picpay.desafio.android.di.component

import androidx.appcompat.app.AppCompatActivity
import com.picpay.desafio.android.di.scope.ActivityScope
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface ActivityComponent {

    fun presentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder
        fun build(): ActivityComponent
    }
}
