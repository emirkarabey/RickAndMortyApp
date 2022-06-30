package com.example.rickandmortyapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EpisodeRetroInstance {
    companion object{
        val BASE_URL = "https://rickandmortyapi.com/api/"

        fun getEpisodeRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}