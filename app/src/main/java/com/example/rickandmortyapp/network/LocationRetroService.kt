package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.LocationList
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationRetroService {

    @GET("location")
    suspend fun getLocationDataFromAPI(@Query("page") query:Int): LocationList
}