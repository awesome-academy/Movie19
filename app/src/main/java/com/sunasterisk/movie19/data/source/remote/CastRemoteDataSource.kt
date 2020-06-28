package com.sunasterisk.movie19.data.source.remote

import io.reactivex.rxjava3.core.Observable
import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.model.DataCredits
import com.sunasterisk.movie19.data.source.CastDataSource

class CastRemoteDataSource(
    private val apiService: ApiService
) : CastDataSource.Remote {
    override fun getCasts(movieId: Int): Observable<DataCredits> =
        apiService.getCastAndCrew(movieId)
}
