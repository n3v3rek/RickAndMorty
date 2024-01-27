package com.example.rickandmorty.repository.dto

data class CharacterDetails(
    var id: String,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var origin: Origin,
    var location: Location,
    var episode: List<String>,
    var image: String
)

data class Location(
    var name: String,
    var url: String
)

data class Origin(
    var name: String,
    var url: String
)