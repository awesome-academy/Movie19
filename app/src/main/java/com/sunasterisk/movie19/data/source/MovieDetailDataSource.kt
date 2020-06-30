package com.sunasterisk.movie19.data.source

import com.sunasterisk.movie19.data.model.DataMovieDetail
import io.reactivex.rxjava3.core.Observable

interface MovieDetailDataSource {
    interface Remote{
        fun getMovieDetail(movieId: Int): Observable<DataMovieDetail>
    }
}
