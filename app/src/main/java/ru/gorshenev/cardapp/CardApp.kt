package ru.gorshenev.cardapp

import android.app.Application
import android.util.Log
import ru.gorshenev.cardapp.di.AppComponent
import ru.gorshenev.cardapp.di.DaggerAppComponent

class CardApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().context(this).build()
    }
}