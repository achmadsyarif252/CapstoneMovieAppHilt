package com.example.capstonemovieapp

import android.app.Application
import com.example.capstonemovieapp.core.di.CoreComponent
import com.example.capstonemovieapp.core.di.DaggerCoreComponent
import com.example.capstonemovieapp.di.AppComponent
import com.example.capstonemovieapp.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}