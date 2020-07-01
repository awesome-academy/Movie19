package com.sunasterisk.movie19.ui.search.view

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseActivity
import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.api.ServiceBuilder
import com.sunasterisk.movie19.data.repository.SearchRepository
import com.sunasterisk.movie19.data.source.remote.SearchRemoteDataSource
import com.sunasterisk.movie19.databinding.ActivitySearchBinding
import com.sunasterisk.movie19.ui.moviedetail.view.MovieDetailActivity
import com.sunasterisk.movie19.ui.search.SearchViewModel
import com.sunasterisk.movie19.ui.search.adapter.SearchMovieAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity<ActivitySearchBinding>() {

    private val searchMovieAdapter = SearchMovieAdapter().apply {
        setItemClick {
            startActivity(MovieDetailActivity.getIntent(this@SearchActivity, it))
        }
    }

    private val viewModel by lazy {
        val apiService = ServiceBuilder.buildService(ApiService::class.java)
        val searchRemoteDataSource = SearchRemoteDataSource(apiService)
        val searchRepository = SearchRepository(searchRemoteDataSource)
        SearchViewModel(searchRepository)
    }

    override val layoutId: Int get() = R.layout.activity_search

    override fun initComponents() {
        databinding.recyclerviewSearchMovie.adapter = searchMovieAdapter
        databinding.viewModel = viewModel
        setOnClickSearch()
        setActionbar()
    }

    fun setOnClickSearch() {
        editTextSearchMovie.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.isEmpty()) {
                    textViewNoData.visibility = View.VISIBLE
                    recyclerviewSearchMovie.visibility = View.INVISIBLE
                } else {
                    textViewNoData.visibility = View.INVISIBLE
                    recyclerviewSearchMovie.visibility = View.VISIBLE
                    viewModel.getMovieSearch(p0.toString(), recyclerviewSearchMovie, textViewNoData)
                }
            }
        })
    }

    fun setActionbar() {
        setSupportActionBar(toolbarSearch)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        toolbarSearch.setNavigationOnClickListener {
            finish()
        }
    }

    companion object {
        fun getIntent(context: Context) =
            Intent(context, SearchActivity::class.java)
    }
}
