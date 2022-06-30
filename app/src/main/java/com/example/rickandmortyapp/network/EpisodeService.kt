package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.EpisodeList
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeRetroService {

    @GET("episode")
    suspend fun getEpisodeDataFromAPI(@Query("page") query:Int): EpisodeList
}