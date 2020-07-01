package com.sunasterisk.movie19.data.source.remote

import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.model.DataCredits
import com.sunasterisk.movie19.data.source.CastDataSource
import io.reactivex.Observable

class CastRemoteDataSource(
    private val apiService: ApiService
) : CastDataSource.Remote {
    override fun getCasts(movieId: Int): Observable<DataCredits> =
        apiService.getCastAndCrew(movieId)
}
