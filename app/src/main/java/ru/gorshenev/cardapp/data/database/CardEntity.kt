package ru.gorshenev.cardapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.gorshenev.cardapp.data.network.Bank
import ru.gorshenev.cardapp.data.network.Country
import ru.gorshenev.cardapp.data.network.Number

@Entity(tableName = AppDataBase.CARD)
data class CardEntity(
    @PrimaryKey val cardNumber: String,
    @Embedded(prefix = "number") val number: Number?,
    @ColumnInfo(name = "scheme") val scheme: String?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "brand") val brand: String?,
    @ColumnInfo(name = "prepaid") val prepaid: Boolean?,
    @Embedded(prefix = "country") val country: Country?,
    @Embedded(prefix = "bank") val bank: Bank?,
)