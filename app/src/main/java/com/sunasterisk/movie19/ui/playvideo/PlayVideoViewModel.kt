package com.sunasterisk.movie19.ui.playvideo

import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.repository.MovieTrailerRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject

class PlayVideoViewModel(private val repository: MovieTrailerRepository) : BaseViewModel() {

    val subject = PublishSubject.create<String>()
    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getVideo(movieId: Int) {
        repository.getVideoTrailer(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                subject.onNext(it.results[0].key)
            }
            .addTo(compositeDisposable)
    }
}
