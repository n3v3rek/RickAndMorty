package com.example.rickandmorty.repository

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("/api/character")
    suspend fun getRickAndMortyResponse(): Response<RickAndMortyResponse>

    companion object {
        private const val RICK_AND_MORTY_URL = "https://rickandmortyapi.com/api/"
        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(RICK_AND_MORTY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val rickAndMortyService: RickAndMortyService by lazy {
            retrofit.create(RickAndMortyService::class.java)
        }
    }
}