package com.sunasterisk.movie19.ui.playvideo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.sunasterisk.movie19.BuildConfig
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.api.ServiceBuilder
import com.sunasterisk.movie19.data.repository.MovieTrailerRepository
import com.sunasterisk.movie19.data.source.remote.VideoTrailerRemoteDataSource
import com.sunasterisk.movie19.utils.Constants
import kotlinx.android.synthetic.main.activity_play_video.*

class PlayVideoActivity : YouTubeBaseActivity() {

    private val viewModel by lazy {
        val apiService = ServiceBuilder.buildService(ApiService::class.java)
        val videoTrailerRemoteDataSource = VideoTrailerRemoteDataSource(apiService)
        val videoTrailerRepository = MovieTrailerRepository(videoTrailerRemoteDataSource)
        PlayVideoViewModel(videoTrailerRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)
        val movieId = intent.getIntExtra(Constants.EXTRA_ID_MOVIE, -1)
        viewModel.getVideo(movieId)
        viewModel.subject.subscribe {
            playerView.initialize(
                BuildConfig.YOUTUBE_KEY,
                object : com.google.android.youtube.player.YouTubePlayer.OnInitializedListener {
                    override fun onInitializationSuccess(
                        provider: com.google.android.youtube.player.YouTubePlayer.Provider?,
                        youtubePlayer: com.google.android.youtube.player.YouTubePlayer?,
                        wasRestored: Boolean
                    ) {
                        youtubePlayer?.loadVideo(it)
                    }

                    override fun onInitializationFailure(
                        provider: com.google.android.youtube.player.YouTubePlayer.Provider?,
                        error: YouTubeInitializationResult?
                    ){

                    }
                })
        }
    }

    companion object {
        fun getIntent(context: Context, movieId: Int) =
            Intent(context, PlayVideoActivity::class.java)
                .putExtra(Constants.EXTRA_ID_MOVIE, movieId)
    }
}
