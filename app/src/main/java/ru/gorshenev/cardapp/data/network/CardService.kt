package ru.gorshenev.cardapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardService {
    @GET("{id}")
    suspend fun getCard(@Path("id") id: String): CardResponse
}