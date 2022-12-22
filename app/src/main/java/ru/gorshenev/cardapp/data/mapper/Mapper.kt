package ru.gorshenev.cardapp.data.mapper

import ru.gorshenev.cardapp.data.database.CardEntity
import ru.gorshenev.cardapp.data.network.CardResponse
import ru.gorshenev.cardapp.ui.CardUi

object Mapper {
    fun CardResponse.toEntity(id: String): CardEntity {
        return CardEntity(
            cardNumber = id,
            number = number,
            scheme = scheme,
            type = type,
            brand = brand,
            prepaid = isCardPrepaid,
            country = country,
            bank = bank
        )
    }

    fun CardEntity.toCardUi(): CardUi {
        return CardUi(
            numberLength = number?.length?.toString().orEmpty(),
            luhnCheckStatus = number?.isLuhnCheckEnable ?: false,
            scheme = scheme.orEmpty(),
            type = type.orEmpty(),
            brand = brand.orEmpty(),
            cardPrepaidStatus = prepaid ?: false,
            countryName = country?.countryName.orEmpty(),
            countryNumeric = country?.numeric?.toString().orEmpty(),
            countryAlpha2 = country?.alpha2.orEmpty(),
            countryEmoji = country?.emoji.orEmpty(),
            countryCurrency = country?.currency.orEmpty(),
            countryLatitude = country?.latitude?.toString().orEmpty(),
            countryLongitude = country?.longitude?.toString().orEmpty(),
            bankName = bank?.bankName.orEmpty(),
            bankUrl = bank?.url.orEmpty(),
            bankPhone = bank?.phone.orEmpty(),
            bankCity = bank?.city.orEmpty(),
        )
    }
}