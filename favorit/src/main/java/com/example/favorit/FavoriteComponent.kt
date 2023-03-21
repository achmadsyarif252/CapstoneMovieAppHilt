package com.example.favorit

import android.content.Context
import com.example.capstonemovieapp.di.FavoritModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoritModuleDependencies::class])
interface FavoriteComponent {

    fun inject(activity: FavoritActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoritModuleDependencies: FavoritModuleDependencies): Builder
        fun build(): FavoriteComponent
    }

}