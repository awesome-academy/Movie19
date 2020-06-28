package com.sunasterisk.movie19.ui.moviedetail

import androidx.databinding.ObservableField
import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.model.Cast
import com.sunasterisk.movie19.data.repository.CastRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDetailViewModel(
    private val repository: CastRepository
) : BaseViewModel() {

    val casts = ObservableField<List<Cast>>()

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getCasts(idMovie: Int) {
        repository.getCasts(idMovie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                casts.set(it.casts)
            }
            .addTo(compositeDisposable)
    }
}
