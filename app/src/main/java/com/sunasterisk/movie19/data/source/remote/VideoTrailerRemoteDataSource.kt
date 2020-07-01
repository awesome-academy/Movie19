package com.sunasterisk.movie19.data.source.remote

import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.model.DataVideo
import com.sunasterisk.movie19.data.source.VideoTrailerDataSource
import io.reactivex.rxjava3.core.Observable

class VideoTrailerRemoteDataSource(
    private val apiService: ApiService
) : VideoTrailerDataSource.Remote {
    override fun getVideoTrailer(movieId: Int): Observable<DataVideo> =
        apiService.getVideoTrailerMovie(movieId)
}
