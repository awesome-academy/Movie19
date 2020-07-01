package com.sunasterisk.movie19.ui.moviedetail.view

import android.content.Context
import android.content.Intent
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseActivity
import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.api.ServiceBuilder
import com.sunasterisk.movie19.data.model.Movie
import com.sunasterisk.movie19.data.repository.CastRepository
import com.sunasterisk.movie19.data.repository.MovieDetailRepository
import com.sunasterisk.movie19.data.source.remote.CastRemoteDataSource
import com.sunasterisk.movie19.data.source.remote.MovieDetailRemoteDataSource
import com.sunasterisk.movie19.databinding.ActivityMovieDetailBinding
import com.sunasterisk.movie19.ui.moviedetail.MovieDetailViewModel
import com.sunasterisk.movie19.ui.moviedetail.MovieDetailViewModelFactory
import com.sunasterisk.movie19.ui.moviedetail.adapter.CastAdapter
import com.sunasterisk.movie19.ui.playvideo.PlayVideoActivity
import com.sunasterisk.movie19.utils.Constants
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding>() {

    private val castAdapter = CastAdapter()

    private val viewModel by lazy {
        val apiService = ServiceBuilder.buildService(ApiService::class.java)
        val castRemoteDataSource = CastRemoteDataSource(apiService)
        val movieDetailRemoteDataSource = MovieDetailRemoteDataSource(apiService)
        val castRepository = CastRepository(castRemoteDataSource)
        val movieDetailRepository = MovieDetailRepository(movieDetailRemoteDataSource)
        val factory = MovieDetailViewModelFactory(castRepository, movieDetailRepository)
        ViewModelProvider(
            this,
            factory
        ).get(MovieDetailViewModel::class.java)
    }

    override val layoutId: Int get() = R.layout.activity_movie_detail

    override fun initComponents() {

        val movieId: Int = intent.getIntExtra(Constants.EXTRA_ID_MOVIE, -1)
        textViewCategory.isSelected = true

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        databinding.recyclerViewCast.adapter = castAdapter
        databinding.viewModel = viewModel
        viewModel.getCasts(movieId)
        viewModel.getMovieDetail(movieId)

        imageViewVideo.setOnClickListener {
            startActivity(PlayVideoActivity.getIntent(this, movieId))
        }
    }

    companion object {
        fun getIntent(context: Context, movie: Movie) =
            Intent(context, MovieDetailActivity::class.java)
                .putExtra(Constants.EXTRA_ID_MOVIE, movie.id)
    }
}
