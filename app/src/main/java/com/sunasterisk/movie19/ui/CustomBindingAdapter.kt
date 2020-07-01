package com.sunasterisk.movie19.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunasterisk.movie19.data.model.*
import com.sunasterisk.movie19.ui.category.adapter.GenreAdapter
import com.sunasterisk.movie19.ui.favorite.adapter.FavoriteAdapter
import com.sunasterisk.movie19.ui.movie.adapter.MovieAdapter
import com.sunasterisk.movie19.ui.movie.adapter.MovieParentAdapter
import com.sunasterisk.movie19.ui.moviedetail.adapter.CastAdapter
import com.sunasterisk.movie19.ui.search.adapter.SearchMovieAdapter
import com.sunasterisk.movie19.utils.Constants

object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(image: ImageView, urlImage: String?) {
        urlImage?.let {
            Glide.with(image.context)
                .load(Constants.IMAGE_URL + urlImage)
                .into(image)
        }
    }

    @JvmStatic
    @BindingAdapter("dataMovie")
    fun setData(recyclerView: RecyclerView, items: List<Movie>?) {
        items?.let { (recyclerView.adapter as MovieAdapter).submitList(items) }
    }

    @JvmStatic
    @BindingAdapter("dataMovieParent")
    fun setDataMovieParent(recyclerView: RecyclerView, data: List<MovieParent>?) {
        data?.let { (recyclerView.adapter as MovieParentAdapter).submitList(data) }
    }

    @JvmStatic
    @BindingAdapter("dataGenre")
    fun getGenres(recyclerView: RecyclerView, genres: List<Genre>?) {
        genres?.let { (recyclerView.adapter as GenreAdapter).submitList(genres) }
    }

    @JvmStatic
    @BindingAdapter("dataCast")
    fun getCasts(recyclerView: RecyclerView, genres: List<Cast>?) {
        genres?.let { (recyclerView.adapter as CastAdapter).submitList(genres) }
    }

    @JvmStatic
    @BindingAdapter("dataMovieSearch")
    fun getDataMovieSearch(recyclerView: RecyclerView, items: List<Movie>?) {
        items?.let { (recyclerView.adapter as SearchMovieAdapter).submitList(items) }
    }

    @JvmStatic
    @BindingAdapter("dataMovieFavorite")
    fun getDataMovieFavorite(recyclerView: RecyclerView, items: List<Favorite>?) {
        items?.let { (recyclerView.adapter as FavoriteAdapter).submitList(items) }
    }
}
