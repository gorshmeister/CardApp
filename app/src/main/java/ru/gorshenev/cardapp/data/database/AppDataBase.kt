package ru.gorshenev.cardapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CardEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cardDao(): CardDao

    companion object {
        const val DB_NAME = "appDataBase"
        const val CARD = "card"
    }
}