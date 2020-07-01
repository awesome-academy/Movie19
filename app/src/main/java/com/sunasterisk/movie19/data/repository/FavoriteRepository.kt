package com.sunasterisk.movie19.data.repository

import com.sunasterisk.movie19.data.model.Favorite
import com.sunasterisk.movie19.data.source.FavoriteDataSource
import io.reactivex.Completable
import io.reactivex.Observable

class FavoriteRepository(
    private val local: FavoriteDataSource.Local
) : FavoriteDataSource.Local {
    override fun insertMovieFavorite(favorite: Favorite): Completable =
        local.insertMovieFavorite(favorite)


    override fun deleteMovieFavorite(idMovie: Int) =
        local.deleteMovieFavorite(idMovie)

    override fun getMovieFavorites(): Observable<List<Favorite>> =
        local.getMovieFavorites()

    override fun getCountRow(idMovie: Int): Observable<Int> =
        local.getCountRow(idMovie)
}
