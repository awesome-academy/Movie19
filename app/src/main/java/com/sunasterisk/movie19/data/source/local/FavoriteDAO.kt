package com.sunasterisk.movie19.data.source.local

import androidx.room.*
import com.sunasterisk.movie19.data.model.Favorite
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface FavoriteDAO {

    @Insert
    fun insertMovieFavorite(favorite: Favorite): Completable

    @Query("DELETE FROM Favorite WHERE idMovie=:idMovie")
    fun deleteMovieFavorite(idMovie: Int): Single<Int>

    @Query("SELECT * FROM Favorite")
    fun getMovieFavorites(): Observable<List<Favorite>>

    @Query("SELECT COUNT(*) FROM Favorite WHERE idMovie=:idMovie")
    fun getCountRow(idMovie: Int): Observable<Int>
}
