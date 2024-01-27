package com.example.rickandmorty.repository

import com.example.rickandmorty.repository.dto.CharacterDetails
import com.example.rickandmorty.repository.dto.RickAndMortyResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {
    @GET("/api/character")
    suspend fun getRickAndMortyResponse(): Response<RickAndMortyResponse>

    @GET("/api/character/{id}")
    suspend fun getCharacterDetails(@Path(value = "id", encoded = false) id: String): Response<CharacterDetails>

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