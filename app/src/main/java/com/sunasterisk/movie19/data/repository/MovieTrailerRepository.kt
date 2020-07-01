package com.sunasterisk.movie19.data.repository

import com.sunasterisk.movie19.data.model.DataVideo
import com.sunasterisk.movie19.data.source.VideoTrailerDataSource
import io.reactivex.rxjava3.core.Observable

class MovieTrailerRepository(
    private val remote: VideoTrailerDataSource.Remote
) : VideoTrailerDataSource.Remote {
    override fun getVideoTrailer(movieId: Int): Observable<DataVideo> =
        remote.getVideoTrailer(movieId)
}
