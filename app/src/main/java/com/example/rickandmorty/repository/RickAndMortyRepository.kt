package com.example.rickandmorty.repository

import retrofit2.Response

class RickAndMortyRepository {
    suspend fun getRickAndMortyResponse(): Response<RickAndMortyResponse> =
        RickAndMortyService.rickAndMortyService.getRickAndMortyResponse()
}