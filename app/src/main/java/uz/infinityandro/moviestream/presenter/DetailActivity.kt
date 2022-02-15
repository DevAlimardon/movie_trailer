package uz.infinityandro.moviestream.presenter

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import uz.infinityandro.moviestream.databinding.ActivityDetailBinding
import uz.infinityandro.moviestream.util.Constants

class DetailActivity : YouTubeBaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var listener: YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val a = intent.getStringExtra("sava")
        Log.d("AAAA", "onCreate: $a")
        listener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(a)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {

            }

        }

        binding.play.setOnClickListener {
            binding.play.visibility = View.GONE
            binding.player.initialize(Constants.key, listener)
        }

    }


}