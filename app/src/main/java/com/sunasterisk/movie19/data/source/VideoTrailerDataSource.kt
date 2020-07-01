package com.sunasterisk.movie19.data.source

import com.sunasterisk.movie19.data.model.DataVideo
import io.reactivex.Observable

interface VideoTrailerDataSource {
    interface Remote {
        fun getVideoTrailer(movieId: Int): Observable<DataVideo>
    }
}
