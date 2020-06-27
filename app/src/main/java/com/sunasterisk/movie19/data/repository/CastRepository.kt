package com.sunasterisk.movie19.data.repository

import com.sunasterisk.movie19.data.model.DataCredits
import com.sunasterisk.movie19.data.source.CastDataSource
import io.reactivex.rxjava3.core.Observable

class CastRepository(
    private val remote: CastDataSource.Remote
) : CastDataSource.Remote {
    override fun getCasts(movieId: Int): Observable<DataCredits> =
        remote.getCasts(movieId)
}
