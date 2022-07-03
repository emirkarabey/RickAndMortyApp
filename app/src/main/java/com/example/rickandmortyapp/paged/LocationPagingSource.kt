package com.example.rickandmortyapp.paged

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.model.EpisodeData
import com.example.rickandmortyapp.model.LocationData
import com.example.rickandmortyapp.network.EpisodeRetroService
import com.example.rickandmortyapp.network.LocationRetroService
import java.lang.Exception

class LocationPagingSource (val apiService: LocationRetroService):
    PagingSource<Int, LocationData>() {
    override fun getRefreshKey(state: PagingState<Int, LocationData>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationData> {
        return try {
            val nextPage: Int = params.key ?: LocationPagingSource.FIRST_PAGE_INDEX
            val response = apiService.getLocationDataFromAPI(nextPage)

            var nextPageNumber: Int? = null
            if (response?.info?.next != null) {
                val uri = Uri.parse(response?.info?.next!!)
                val nextPageQuery = uri.getQueryParameter("page")

                nextPageNumber = nextPageQuery?.toInt()
            }

            var prevPageNumber: Int? = null
            if (response?.info?.prev != null) {
                val uri = Uri.parse(response?.info?.prev!!)
                val prevPageQuery = uri.getQueryParameter("page")

                prevPageNumber = prevPageQuery?.toInt()
            }

            LoadResult.Page(
                data = response.results,
                prevKey = prevPageNumber,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
}