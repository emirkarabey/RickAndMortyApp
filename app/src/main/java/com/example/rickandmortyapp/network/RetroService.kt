package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.RickAndMortyList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("character")
    suspend fun getDataFromAPI(@Query("page") query:Int): RickAndMortyList
}