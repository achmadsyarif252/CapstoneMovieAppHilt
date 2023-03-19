package com.example.fandom

import android.content.Context
import com.example.capstonemovieapp.di.FandomModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FandomModuleDependencies::class])
interface FandomComponent {

    fun inject(activity: FandomActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: FandomModuleDependencies): Builder
        fun build(): FandomComponent
    }

}