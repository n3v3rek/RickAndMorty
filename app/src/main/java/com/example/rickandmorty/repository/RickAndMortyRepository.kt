package com.example.rickandmorty.repository

import com.example.rickandmorty.repository.dto.CharacterDetails
import com.example.rickandmorty.repository.dto.RickAndMortyResponse
import retrofit2.Response

class RickAndMortyRepository {
    suspend fun getRickAndMortyResponse(): Response<RickAndMortyResponse> =
        RickAndMortyService.rickAndMortyService.getRickAndMortyResponse()

    suspend fun getCharacterDetails(id: String): Response<CharacterDetails> =
        RickAndMortyService.rickAndMortyService.getCharacterDetails(id)
}