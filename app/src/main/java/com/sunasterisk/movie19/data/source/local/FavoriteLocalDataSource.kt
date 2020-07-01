package com.sunasterisk.movie19.data.source.local

import com.sunasterisk.movie19.data.model.Favorite
import com.sunasterisk.movie19.data.source.FavoriteDataSource
import io.reactivex.Completable
import io.reactivex.Observable

class FavoriteLocalDataSource(
    private val favoriteDAO: FavoriteDAO
) : FavoriteDataSource.Local {

    override fun insertMovieFavorite(favorite: Favorite): Completable =
        favoriteDAO.insertMovieFavorite(favorite)

    override fun deleteMovieFavorite(idMovie: Int) =
        favoriteDAO.deleteMovieFavorite(idMovie)

    override fun getMovieFavorites(): Observable<List<Favorite>> =
        favoriteDAO.getMovieFavorites()

    override fun getCountRow(idMovie: Int): Observable<Int> =
        favoriteDAO.getCountRow(idMovie)

}
