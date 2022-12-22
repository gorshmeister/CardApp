package ru.gorshenev.cardapp.data.database

import androidx.room.*

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: CardEntity?)

    @Query("SELECT * FROM card")
    suspend fun getAll(): List<CardEntity>

    @Query("SELECT * FROM card WHERE cardNumber in (:id)")
    suspend fun getById(id: String): CardEntity

    @Delete
    suspend fun deleteCard(card: CardEntity)

}