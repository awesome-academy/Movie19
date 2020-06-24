package com.sunasterisk.movie19.data.source.remote

import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.model.DataGenre
import com.sunasterisk.movie19.data.source.GenreDataSource
import io.reactivex.rxjava3.core.Observable

class GerneRemoteDataSource(
    private val apiService: ApiService
) : GenreDataSource.Remote {

    override fun getGenres(): Observable<DataGenre> = apiService.getGenres()
}
