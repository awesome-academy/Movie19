package com.sunasterisk.movie19.data.source

import com.sunasterisk.movie19.data.model.DataGenre
import io.reactivex.rxjava3.core.Observable

interface GenreDataSource {

    interface Local

    interface Remote {
        fun getGenres(): Observable<DataGenre>
    }
}
