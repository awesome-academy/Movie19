package com.sunasterisk.movie19.data.repository

import com.sunasterisk.movie19.data.model.DataMovieDetail
import com.sunasterisk.movie19.data.source.MovieDetailDataSource
import io.reactivex.Observable

class MovieDetailRepository(
    private val remote: MovieDetailDataSource.Remote
) : MovieDetailDataSource.Remote {
    override fun getMovieDetail(movieId: Int): Observable<DataMovieDetail> =
        remote.getMovieDetail(movieId)
}
