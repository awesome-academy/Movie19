package com.sunasterisk.movie19.ui.favorite

import androidx.databinding.ObservableField
import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.model.Favorite
import com.sunasterisk.movie19.data.repository.FavoriteRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FavoriteViewModel(
    private val repositoryFavorite: FavoriteRepository
) : BaseViewModel() {

    val movieFavorites = ObservableField<List<Favorite>>()

    override val compositeDisposable: CompositeDisposable get() = CompositeDisposable()

    fun getMovieFavorites() =
        compositeDisposable.add(
            repositoryFavorite.getMovieFavorites()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe {
                    movieFavorites.set(it)
                }
        )
}
