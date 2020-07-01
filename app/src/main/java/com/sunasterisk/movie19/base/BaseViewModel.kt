package com.sunasterisk.movie19.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected abstract val compositeDisposable: CompositeDisposable

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
