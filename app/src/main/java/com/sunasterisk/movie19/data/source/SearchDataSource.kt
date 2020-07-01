package com.sunasterisk.movie19.data.source

import com.sunasterisk.movie19.data.model.Data
import io.reactivex.rxjava3.core.Observable

interface SearchDataSource {
    interface Remote {
        fun getMovieSearch(nameMovie: String): Observable<Data>
    }
}
