package ru.gorshenev.cardapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.gorshenev.cardapp.data.mapper.Mapper.toCardUi
import ru.gorshenev.cardapp.data.repository.ICardRepository
import javax.inject.Inject

class CardViewModel @Inject constructor(
    private val repository: ICardRepository
) : ViewModel() {

    private val initialState = CardState(
        card = CardUi.emptyCard(),
        cardsHistory = emptyList(),
        isLoading = false,
        needRefreshCard = false,
        error = null
    )

    val query: MutableState<String> = mutableStateOf("")

    val state: MutableState<CardState> = mutableStateOf(initialState)

    init {
        viewModelScope.launch {
            try {
                state.value =
                    state.value.copy(
                        cardsHistory = repository.getAllCards().map { it.cardNumber },
                        error = null
                    )
            } catch (e: Exception) {
                state.value = state.value.copy(error = e)
            }
        }
    }

    fun loadCard(id: String) {
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch() {
            try {
                repository.getCardFromApi(id).let { card ->
                    repository.addToDb(card)
                    val cardsHistory = repository.getAllCards().map { it.cardNumber }
                    state.value = state.value.copy(
                        card = card.toCardUi(),
                        cardsHistory = cardsHistory,
                        isLoading = false,
                        needRefreshCard = false,
                        error = null
                    )
                }
            } catch (e: Throwable) {
                state.value = state.value.copy(error = e)
            }
        }
    }

    fun getHistoryCard(id: String) {
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            try {
                state.value = state.value.copy(
                    card = repository.getCardFromDb(id).toCardUi(),
                    isLoading = false,
                    needRefreshCard = true,
                    error = null
                )
            } catch (e: Exception) {
                state.value = state.value.copy(error = e)
            }
        }
    }
}