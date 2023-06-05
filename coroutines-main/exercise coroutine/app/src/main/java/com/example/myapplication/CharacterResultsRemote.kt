package com.example.myapplication

data class CharacterResultsRemote(
    val results: List<CharacterRemote>
)

data class CharacterRemote(
    val name: String,
    val image: String
)

