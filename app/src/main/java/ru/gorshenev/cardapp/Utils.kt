package ru.gorshenev.cardapp

import android.content.Context
import ru.gorshenev.cardapp.data.database.CardEntity
import ru.gorshenev.cardapp.data.network.CardResponse
import ru.gorshenev.cardapp.di.AppComponent

object Utils {
    val Context.appComponent: AppComponent
        get() = when (this) {
            is CardApp -> appComponent
            else -> this.applicationContext.appComponent
        }
}