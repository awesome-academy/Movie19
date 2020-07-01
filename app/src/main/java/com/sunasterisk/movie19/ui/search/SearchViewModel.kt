package com.sunasterisk.movie19.ui.search

import android.view.View
import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.model.Movie
import com.sunasterisk.movie19.data.repository.SearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers.io

class SearchViewModel(
    private val repository: SearchRepository
) : BaseViewModel() {

    val movies = ObservableField<List<Movie>>()

    override val compositeDisposable: CompositeDisposable get() = CompositeDisposable()

    fun getMovieSearch(nameMovie: String, recyclerView: RecyclerView, textView: TextView) {
        repository.getMovieSearch(nameMovie)
            .subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it.results.isEmpty()) {
                    recyclerView.visibility = View.INVISIBLE
                    textView.visibility = View.VISIBLE
                }
                movies.set(it.results)
            }
            .addTo(compositeDisposable)

    }
}
