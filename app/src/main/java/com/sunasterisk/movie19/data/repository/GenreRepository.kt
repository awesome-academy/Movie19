package com.sunasterisk.movie19.data.repository

import com.sunasterisk.movie19.data.model.DataGenre
import com.sunasterisk.movie19.data.source.GenreDataSource
import io.reactivex.Observable

class GenreRepository(
    private val remote: GenreDataSource.Remote
) : GenreDataSource.Remote {

    override fun getGenres(): Observable<DataGenre> = remote.getGenres()
}
