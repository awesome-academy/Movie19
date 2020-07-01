package com.sunasterisk.movie19.data.source

import com.sunasterisk.movie19.data.model.DataCredits
import io.reactivex.Observable

interface CastDataSource {
    interface Remote {
        fun getCasts(movieId: Int): Observable<DataCredits>
    }
}
