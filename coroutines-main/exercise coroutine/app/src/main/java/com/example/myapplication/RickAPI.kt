package com.example.myapplication

import retrofit2.http.GET
import retrofit2.http.Query

interface RickAPI {
    @GET("character")
    suspend fun getCharacters(): CharacterResultsRemote

}
