package com.sunasterisk.movie19.data.source

import io.reactivex.rxjava3.core.Observable
import com.sunasterisk.movie19.data.model.DataCredits

interface CastDataSource {
    interface Remote {
        fun getCasts(movieId: Int): Observable<DataCredits>
    }
}
