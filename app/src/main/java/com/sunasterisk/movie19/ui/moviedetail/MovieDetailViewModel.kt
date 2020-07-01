package com.sunasterisk.movie19.ui.moviedetail

import android.graphics.Color
import android.widget.Toolbar
import androidx.databinding.ObservableField
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.model.Cast
import com.sunasterisk.movie19.data.model.DataMovieDetail
import com.sunasterisk.movie19.data.repository.CastRepository
import com.sunasterisk.movie19.data.repository.MovieDetailRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDetailViewModel(
    private val castRepository: CastRepository,
    private val movieDetailRepository: MovieDetailRepository
) : BaseViewModel() {

    val casts = ObservableField<List<Cast>>()
    val movieDetail = ObservableField<DataMovieDetail>()

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getCasts(idMovie: Int) {
        castRepository.getCasts(idMovie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                casts.set(it.casts)
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
}
