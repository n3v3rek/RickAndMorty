package com.example.rickandmorty.repository

data class RickAndMortyResponse(
    var results: List<RickAndMortyData>
)

data class RickAndMortyData(
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var gender: String,
    var image: String
)
