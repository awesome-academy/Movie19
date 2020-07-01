package com.sunasterisk.movie19.data.repository

import com.sunasterisk.movie19.data.model.Data
import com.sunasterisk.movie19.data.source.SearchDataSource
import io.reactivex.Observable

class SearchRepository(
    private val remote: SearchDataSource.Remote
) : SearchDataSource.Remote {
    override fun getMovieSearch(nameMovie: String): Observable<Data> =
        remote.getMovieSearch(nameMovie)
}
