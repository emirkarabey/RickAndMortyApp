package com.example.rickandmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyapp.model.CharacterData
import com.example.rickandmortyapp.model.EpisodeData
import com.example.rickandmortyapp.network.EpisodeRetroInstance
import com.example.rickandmortyapp.network.EpisodeRetroService
import com.example.rickandmortyapp.network.RetroInstance
import com.example.rickandmortyapp.network.RetroService
import com.example.rickandmortyapp.paged.CharacterPagingSource
import com.example.rickandmortyapp.paged.EpisodePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor():ViewModel() {

    lateinit var retroService: EpisodeRetroService

    init {
        retroService = EpisodeRetroInstance.getEpisodeRetroInstance().create(EpisodeRetroService::class.java)
    }

    fun getListData(): Flow<PagingData<EpisodeData>> {
        return Pager(config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = { EpisodePagingSource(retroService) }).flow.cachedIn(viewModelScope)
    }
}