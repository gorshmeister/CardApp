package ru.gorshenev.cardapp.ui

data class CardUi(
    val numberLength: String,
    val scheme: String,
    val type: String,
    val brand: String,
    val countryNumeric: String,
    val countryAlpha2: String,
    val countryName: String,
    val countryEmoji: String,
    val countryCurrency: String,
    val countryLatitude: String,
    val countryLongitude: String,
    val bankName: String,
    val bankUrl: String,
    val bankPhone: String,
    val bankCity: String,
    val luhnCheckStatus: Boolean,
    val cardPrepaidStatus: Boolean,
) {
    companion object {
        fun emptyCard(): CardUi {
            return CardUi(
                numberLength = "16", scheme = "Visa",
                type = "Debit",
                brand = "Visa",
                countryNumeric = "208",
                countryAlpha2 = "DK",
                countryName = "Denmark",
                countryEmoji = "\uD83C\uDDE9\uD83C\uDDF0",
                countryCurrency = "DKK",
                countryLatitude = "56",
                countryLongitude = "10",
                bankName = "Jyske Bank",
                bankUrl = "www.jyskebank.dk",
                bankPhone = "+4589893300",
                bankCity = "Hjørring",
                luhnCheckStatus = false,
                cardPrepaidStatus = true
            )
        }
    }
}