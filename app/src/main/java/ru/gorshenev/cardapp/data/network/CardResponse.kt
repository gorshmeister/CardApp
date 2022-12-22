package ru.gorshenev.cardapp.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardResponse(
    @SerialName("number") val number: Number? = null,
    @SerialName("scheme") val scheme: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("brand") val brand: String? = null,
    @SerialName("prepaid") val isCardPrepaid: Boolean? = null,
    @SerialName("country") val country: Country? = null,
    @SerialName("bank") val bank: Bank? = null,
)

@Serializable
data class Number(
    @SerialName("length") val length: Int? = null,
    @SerialName("luhn") val isLuhnCheckEnable: Boolean? = null,
)


@Serializable
data class Country(
    @SerialName("numeric") val numeric: Int? = null,
    @SerialName("alpha2") val alpha2: String? = null,
    @SerialName("name") val countryName: String? = null,
    @SerialName("emoji") val emoji: String? = null,
    @SerialName("currency") val currency: String? = null,
    @SerialName("latitude") val latitude: Int? = null,
    @SerialName("longitude") val longitude: Int? = null,
)

@Serializable
data class Bank(
    @SerialName("name") val bankName: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("phone") val phone: String? = null,
    @SerialName("city") val city: String? = null,
)
