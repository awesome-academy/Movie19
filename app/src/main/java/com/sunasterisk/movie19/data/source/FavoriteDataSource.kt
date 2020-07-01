package com.sunasterisk.movie19.data.source

import com.sunasterisk.movie19.data.model.Favorite
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface FavoriteDataSource {
    interface Local {
        fun insertMovieFavorite(favorite: Favorite): Completable
        fun deleteMovieFavorite(idMovie: Int): Single<Int>
        fun getMovieFavorites(): Observable<List<Favorite>>
        fun getCountRow(idMovie: Int): Observable<Int>
    }
}
