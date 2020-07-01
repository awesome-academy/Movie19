package com.sunasterisk.movie19.data.api

import com.sunasterisk.movie19.data.model.*
import com.sunasterisk.movie19.data.model.Data
import com.sunasterisk.movie19.data.model.DataCredits
import com.sunasterisk.movie19.data.model.DataGenre
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    fun getUpcoming(@Query("page") page: Int): Observable<Data>

    @GET("movie/popular")
    fun getTopRated(@Query("page") page: Int): Observable<Data>

    @GET("movie/top_rated")
    fun getPopular(@Query("page") page: Int): Observable<Data>

    @GET("movie/upcoming")
    fun getNowPlaying(@Query("page") page: Int): Observable<Data>

    @GET("genre/movie/list")
    fun getGenres(): Observable<DataGenre>

    @GET("movie/{movie_id}/credits")
    fun getCastAndCrew(@Path("movie_id") movieId: Int): Observable<DataCredits>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): Observable<DataMovieDetail>

    @GET("movie/{movie_id}/videos")
    fun getVideoTrailerMovie(@Path("movie_id") movieId: Int): Observable<DataVideo>

    @GET("search/movie")
    fun getMovieSearch(@Query("query") nameMovie: String): Observable<Data>
}
