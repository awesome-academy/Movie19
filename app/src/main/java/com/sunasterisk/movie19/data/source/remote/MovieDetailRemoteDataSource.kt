package com.sunasterisk.movie19.data.source.remote

import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.model.DataMovieDetail
import com.sunasterisk.movie19.data.source.MovieDetailDataSource
import io.reactivex.Observable

class MovieDetailRemoteDataSource(
    private val apiService: ApiService
) : MovieDetailDataSource.Remote {
    override fun getMovieDetail(movieId: Int): Observable<DataMovieDetail> =
        apiService.getMovieDetail(movieId)
}
