package uz.infinityandro.moviestream.presenter.pages

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.PageDetailBinding
import uz.infinityandro.moviestream.presenter.DetailActivity
import uz.infinityandro.moviestream.presenter.adapter.GenreAdapter
import uz.infinityandro.moviestream.presenter.adapter.SmilarAdapter
import uz.infinityandro.moviestream.presenter.viewmodel.DetailViewModel
import uz.infinityandro.moviestream.presenter.viewmodel.YouTubeModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.DetailIViewModelImpl
import uz.infinityandro.moviestream.presenter.viewmodel.impl.YouTubeModelImpl
import uz.infinityandro.moviestream.util.InternetBroadCast
import uz.infinityandro.moviestream.utils.showToast

class PageDetail : Fragment(R.layout.page_detail) {
    private val binding by viewBinding(PageDetailBinding::bind)
    private val viewModel: DetailViewModel by viewModel<DetailIViewModelImpl>()
    private lateinit var adapter: SmilarAdapter
    private lateinit var adapterCast: GenreAdapter
    private val receiver = InternetBroadCast()
    private val viewModelData: YouTubeModel by viewModel<YouTubeModelImpl>()
    var name = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SmilarAdapter {
            val fragment = PageDetail()
            var bundle = Bundle()
            bundle.putString("salom", it.id)
            fragment.arguments = bundle
            findNavController().navigate(R.id.pageDetail, bundle)
        }
        adapterCast = GenreAdapter {
            var fragment = PageActors()
            var bundle = Bundle()
            bundle.putString("id", it.id)
            fragment.arguments = bundle
            findNavController().navigate(R.id.pageActors, bundle)
        }
        var a = arguments?.get("salom") as String
        binding.shimmer.startShimmer()
        recyclerActors.adapter = adapterCast
        recyclerSmilarFilms.adapter = adapter
        viewModelListeners()
        requireContext().registerReceiver(
            receiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
        requireContext().registerReceiver(
            receiver,
            IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        )
        receiver.setListener {
            if (it) {
                viewModel.getMovie(a)
                return@setListener
            }
        }
        receiver.setNetwork {
            if (it) {
                viewModel.getMovie(a)
                return@setNetwork
            }
        }
        viewModel.getMovie(a)

    }

    private fun viewModelListeners() = with(binding) {
        back.setOnClickListener {
            findNavController().popBackStack()
        }
        btnTrailer.setOnClickListener { ha ->
            Intent(requireContext(), DetailActivity::class.java).let { data ->
                data.putExtra("sava", name)
                startActivity(data)
            }
        }
        viewModelData.dataFlow.onEach { aaa ->
            Log.d("AAAAA", "onCreate: ${aaa.videoId}")
            name = aaa.videoId.toString()
        }.launchIn(lifecycleScope)
        viewModel.dataFlow.onEach {
            if (it != null) {
                Glide.with(requireContext()).load(it.image).into(imageFilm)
                nameFilm.text = it.title
                timeFilm.text = it.runtimeStr
                rateFilm.text = "${it.imDbRating}(IMDb)"
                releaseDateFilm.text = it.releaseDate
                if (!it.genreList!![0].value.isNullOrEmpty()) {
                    genre1.text = it.genreList[0].value
                } else {

                }
                if (it.genreList.size >= 2) {
                    if (!it.genreList[1].value.isNullOrEmpty()) {
                        genre2.text = it.genreList[1].value
                    } else {
                        genre2.visibility = View.GONE
                    }
                }
                descriptionFilm.text = it.plot
                adapter.addFiles(it.similars!!)
                adapterCast.addFiles(it.actorList!!)
                viewModelData.getMovie(it.id!!)
            }
        }.launchIn(lifecycleScope)

        viewModel.errorFlow.onEach {
            showToast(it)
        }.launchIn(lifecycleScope)

        viewModel.progressFlow.onEach {
            if (!it) {
                Handler(Looper.myLooper()!!).postDelayed(object : Runnable {
                    override fun run() {
                        shimmer.stopShimmer()
                        shimmer.visibility = View.GONE
                        layout.visibility = View.VISIBLE
                    }

                }, 1000)
            } else {
                shimmer.startShimmer()
                shimmer.visibility = View.VISIBLE
                layout.visibility = View.GONE
            }
        }.launchIn(lifecycleScope)
    }
}