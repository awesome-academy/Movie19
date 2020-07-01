package com.sunasterisk.movie19.data.source.remote

import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.model.Data
import com.sunasterisk.movie19.data.source.SearchDataSource
import io.reactivex.rxjava3.core.Observable

class SearchRemoteDataSource(
    private val apiService: ApiService
) : SearchDataSource.Remote {
    override fun getMovieSearch(nameMovie: String): Observable<Data> =
        apiService.getMovieSearch(nameMovie)
}
