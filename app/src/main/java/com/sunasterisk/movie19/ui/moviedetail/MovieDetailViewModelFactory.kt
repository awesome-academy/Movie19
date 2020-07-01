package com.sunasterisk.movie19.ui.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunasterisk.movie19.data.repository.CastRepository
import com.sunasterisk.movie19.data.repository.FavoriteRepository
import com.sunasterisk.movie19.data.repository.MovieDetailRepository

class MovieDetailViewModelFactory(
    private val repositoryCast: CastRepository,
    private val repositoryMovieDetail: MovieDetailRepository,
    private val repositoryFavorite: FavoriteRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            CastRepository::class.java,
            MovieDetailRepository::class.java,
            FavoriteRepository::class.java
        ).newInstance(
            repositoryCast,
            repositoryMovieDetail,
            repositoryFavorite
        )
}
