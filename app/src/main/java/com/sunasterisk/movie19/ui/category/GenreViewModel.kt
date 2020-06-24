package com.sunasterisk.movie19.ui.category

import androidx.databinding.ObservableField
import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.model.Genre
import com.sunasterisk.movie19.data.repository.GenreRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

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
