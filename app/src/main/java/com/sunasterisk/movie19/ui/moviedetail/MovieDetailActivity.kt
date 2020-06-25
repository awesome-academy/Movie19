package com.sunasterisk.movie19.ui.moviedetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.data.model.Movie
import com.sunasterisk.movie19.utils.Constants

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
    }

    companion object {
        fun getIntent(context: Context, movie: Movie) =
            Intent(context, MovieDetailActivity::class.java)
                .putExtra(Constants.EXTRA_ID_MOVIE, movie.id)
    }
}
