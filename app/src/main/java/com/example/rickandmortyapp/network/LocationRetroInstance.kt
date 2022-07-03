package com.example.rickandmortyapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationRetroInstance {
    companion object{
        val BASE_URL = "https://rickandmortyapi.com/api/"

        fun getLocationRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}