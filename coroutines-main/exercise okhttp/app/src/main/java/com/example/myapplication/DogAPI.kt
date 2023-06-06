package com.example.myapplication

import retrofit2.http.GET
import retrofit2.http.Query

interface DogAPI {
    @GET("dog_breeds")
    suspend fun getDogs(): List<DogsRemote>
}
