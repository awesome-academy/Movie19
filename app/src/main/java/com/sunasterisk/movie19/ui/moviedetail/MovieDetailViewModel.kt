package com.sunasterisk.movie19.ui.moviedetail

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.ObservableField
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.model.Cast
import com.sunasterisk.movie19.data.model.DataMovieDetail
import com.sunasterisk.movie19.data.model.Favorite
import com.sunasterisk.movie19.data.repository.CastRepository
import com.sunasterisk.movie19.data.repository.FavoriteRepository
import com.sunasterisk.movie19.data.repository.MovieDetailRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class MovieDetailViewModel(
    private val castRepository: CastRepository,
    private val movieDetailRepository: MovieDetailRepository,
    private val repositoryFavorite: FavoriteRepository
) : BaseViewModel() {

    val casts = ObservableField<List<Cast>>()
    val movieDetail = ObservableField<DataMovieDetail>()
    val countRow = ObservableField<Int>()

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getCasts(idMovie: Int, imageView: ImageView, context: Context) {
        castRepository.getCasts(idMovie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                casts.set(it.casts)
                repositoryFavorite.getCountRow(it.id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe {
                        countRow.set(it)
                        if (it == 1) {
                            imageView.setImageDrawable(context.resources.getDrawable(R.drawable.ic_baseline_favorite))
                        } else {
                            imageView.setImageDrawable(context.resources.getDrawable(R.drawable.ic_baseline_favorite_24))
                        }
                    }
            }
            .addTo(compositeDisposable)
    }

    fun getMovieDetail(movieId: Int, toolbar: CollapsingToolbarLayout) {
        movieDetailRepository.getMovieDetail(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieDetail.set(it)
                toolbar.title = it.title
                toolbar.setCollapsedTitleTextColor(Color.WHITE)
            },
                {

                }
            )
            .addTo(compositeDisposable)
    }

    fun insertMovieFavorite() {
        repositoryFavorite.insertMovieFavorite(
            Favorite(
                nameMovie = movieDetail.get()!!.title,
                posterPath = movieDetail.get()!!.posterPath,
                releaseDate = movieDetail.get()!!.releaseDate,
                idMovie = movieDetail.get()!!.id
            )
        ).subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe {
            }
            .addTo(compositeDisposable)
    }

    fun deleteMovieFavorite() {
        repositoryFavorite.deleteMovieFavorite(
            movieDetail.get()!!.id
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },
                {

                })
            .addTo(compositeDisposable)
    }

    fun setFavorite() {
        if (countRow.get() == 1) {
            deleteMovieFavorite()
        } else {
            insertMovieFavorite()
        }
    }
}
