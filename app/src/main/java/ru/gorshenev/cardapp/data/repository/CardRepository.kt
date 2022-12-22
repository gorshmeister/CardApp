package ru.gorshenev.cardapp.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.gorshenev.cardapp.data.database.AppDataBase
import ru.gorshenev.cardapp.data.database.CardEntity
import ru.gorshenev.cardapp.data.mapper.Mapper.toEntity
import ru.gorshenev.cardapp.data.network.CardService
import javax.inject.Inject

class CardRepository @Inject constructor(
    private val api: CardService,
    private val db: AppDataBase,
    private val executionDispatcher: CoroutineDispatcher
) : ICardRepository {

    override suspend fun getCardFromApi(id: String) = withContext(executionDispatcher) {
        api.getCard(id).toEntity(id)
    }

    override suspend fun getCardFromDb(id: String) = withContext(executionDispatcher) {
        db.cardDao().getById(id)
    }

    override suspend fun getAllCards() = withContext(executionDispatcher) {
        db.cardDao().getAll()
    }

    override suspend fun addToDb(card: CardEntity) = withContext(executionDispatcher) {
        db.cardDao().insertCard(card)
    }

}