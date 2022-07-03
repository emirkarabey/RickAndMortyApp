package com.example.rickandmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyapp.model.EpisodeData
import com.example.rickandmortyapp.model.LocationData
import com.example.rickandmortyapp.network.EpisodeRetroInstance
import com.example.rickandmortyapp.network.EpisodeRetroService
import com.example.rickandmortyapp.network.LocationRetroInstance
import com.example.rickandmortyapp.network.LocationRetroService
import com.example.rickandmortyapp.paged.EpisodePagingSource
import com.example.rickandmortyapp.paged.LocationPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(): ViewModel() {

    lateinit var retroService: LocationRetroService

    init {
        retroService = LocationRetroInstance.getLocationRetroInstance().create(LocationRetroService::class.java)
    }

    fun getListData(): Flow<PagingData<LocationData>> {
        return Pager(config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = { LocationPagingSource(retroService) }).flow.cachedIn(viewModelScope)
    }
}