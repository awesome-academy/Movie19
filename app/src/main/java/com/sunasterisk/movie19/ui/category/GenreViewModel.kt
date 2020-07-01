package com.sunasterisk.movie19.ui.category

import androidx.databinding.ObservableField
import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.model.Genre
import com.sunasterisk.movie19.data.repository.GenreRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class GenreViewModel(private val repository: GenreRepository) : BaseViewModel() {

    val genres = ObservableField<List<Genre>>()

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getGenres() {
        repository.getGenres()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                genres.set(it.genres)
            }
            .addTo(compositeDisposable)
    }
}
