package com.sunasterisk.movie19.ui.favorite.view

import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseFragment
import com.sunasterisk.movie19.data.repository.FavoriteRepository
import com.sunasterisk.movie19.data.source.local.FavoriteDatabase
import com.sunasterisk.movie19.data.source.local.FavoriteLocalDataSource
import com.sunasterisk.movie19.databinding.FragmentFavoriteBinding
import com.sunasterisk.movie19.ui.favorite.FavoriteViewModel
import com.sunasterisk.movie19.ui.favorite.adapter.FavoriteAdapter
import com.sunasterisk.movie19.ui.moviedetail.view.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val favoriteAdapter = FavoriteAdapter().apply {
        setItemClick {
            startActivity(MovieDetailActivity.getIntentFavorite(context!!,it))
        }
    }
    private val viewModel by lazy {
        val database = FavoriteDatabase.getIntance(context!!)
        val favoriteDao = database.favoriteDao()
        val favoriteLocalDataSource = FavoriteLocalDataSource(favoriteDao)
        val favoriteRepository = FavoriteRepository(favoriteLocalDataSource)
        FavoriteViewModel(favoriteRepository)
    }

    override val layoutId: Int get() = R.layout.fragment_favorite

    override fun initializeComponent() {
        recyclerViewFavoriteMovie.adapter = favoriteAdapter
        binding.viewModel = viewModel
        viewModel.getMovieFavorites()
    }

}
