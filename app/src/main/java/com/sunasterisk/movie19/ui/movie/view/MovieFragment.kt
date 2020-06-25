package com.sunasterisk.movie19.ui.movie.view

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseFragment
import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.api.ServiceBuilder
import com.sunasterisk.movie19.data.repository.MovieRepository
import com.sunasterisk.movie19.data.source.remote.MovieRemoteDataSource
import com.sunasterisk.movie19.databinding.FragmentMovieBinding
import com.sunasterisk.movie19.ui.movie.adapter.MovieParentAdapter
import com.sunasterisk.movie19.ui.movie.MovieViewModel
import com.sunasterisk.movie19.ui.search.SearchActivity
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : BaseFragment<FragmentMovieBinding>() {

    private val movieParentAdapter: MovieParentAdapter =
        MovieParentAdapter()

    private val viewModel by lazy {
        val apiService = ServiceBuilder.buildService(ApiService::class.java)
        val movieRemoteDataSource = MovieRemoteDataSource(apiService)
        val movieRepository = MovieRepository(movieRemoteDataSource)
        MovieViewModel(
            movieRepository
        )
    }

    override val layoutId get() = R.layout.fragment_movie

    override fun initializeComponent() {
        binding.recyclerViewMovie.adapter = movieParentAdapter
        binding.viewModel = viewModel
        viewModel.getMovies()
        toolbar.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_actionbar_search -> {
                context?.startActivity(SearchActivity.getIntent(context!!))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_actionbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
