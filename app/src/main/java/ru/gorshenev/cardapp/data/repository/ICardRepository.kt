package ru.gorshenev.cardapp.data.repository

import ru.gorshenev.cardapp.data.database.CardEntity

interface ICardRepository {

    suspend fun getCardFromApi(id: String): CardEntity
    suspend fun getCardFromDb(id: String): CardEntity
    suspend fun getAllCards(): List<CardEntity>
    suspend fun addToDb(card: CardEntity)

}