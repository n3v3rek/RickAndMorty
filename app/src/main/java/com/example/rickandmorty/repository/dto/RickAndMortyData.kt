package com.example.rickandmorty.repository.dto

data class RickAndMortyResponse(
    var results: List<RickAndMortyData>
)

data class RickAndMortyData(
    var id: String,
    var name: String,
    var status: String,
    var species: String,
    var gender: String,
    var image: String
)
