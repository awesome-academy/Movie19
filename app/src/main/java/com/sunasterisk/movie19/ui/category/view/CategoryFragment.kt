package com.sunasterisk.movie19.ui.category.view

import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseFragment
import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.api.ServiceBuilder
import com.sunasterisk.movie19.data.repository.GenreRepository
import com.sunasterisk.movie19.data.source.remote.GerneRemoteDataSource
import com.sunasterisk.movie19.databinding.FragmentCategoryBinding
import com.sunasterisk.movie19.ui.category.GenreViewModel
import com.sunasterisk.movie19.ui.category.adapter.GenreAdapter

class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    private val genreadapter: GenreAdapter = GenreAdapter()

    private val viewModel by lazy {
        val apiService = ServiceBuilder.buildService(ApiService::class.java)
        val movieRemoteDataSource = GerneRemoteDataSource(apiService)
        val movieRepository = GenreRepository(movieRemoteDataSource)
        GenreViewModel(
            movieRepository
        )
    }

    override val layoutId: Int get() = R.layout.fragment_category

    override fun initializeComponent() {
        binding.recyclerViewCategory.adapter = genreadapter
        binding.viewModel = viewModel
        viewModel.getGenres()
    }
}
