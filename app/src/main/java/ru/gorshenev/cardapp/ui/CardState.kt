package ru.gorshenev.cardapp.ui

data class CardState(
    val card: CardUi,
    val cardsHistory: List<String>,
    val isLoading: Boolean,
    val needRefreshCard: Boolean,
    val error: Throwable?
) {
}