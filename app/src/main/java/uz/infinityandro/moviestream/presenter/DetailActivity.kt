package uz.infinityandro.moviestream.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.ActivityDetailBinding
import uz.infinityandro.moviestream.presenter.adapter.GenreAdapter
import uz.infinityandro.moviestream.presenter.adapter.SmilarAdapter
import uz.infinityandro.moviestream.presenter.viewmodel.DetailViewModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.DetailIViewModelImpl
import uz.infinityandro.moviestream.util.Constants
import uz.infinityandro.moviestream.utils.displayToast
import uz.infinityandro.moviestream.utils.showToast

class DetailActivity : YouTubeBaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var listener: YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val a=intent.getStringExtra("sava")
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
        binding.play.visibility=View.GONE
        binding.player.initialize(Constants.key,listener)
    }

    }


}