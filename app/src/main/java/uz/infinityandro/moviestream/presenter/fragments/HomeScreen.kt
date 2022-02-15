package uz.infinityandro.moviestream.presenter.fragments

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.ScreenHomeBinding
import uz.infinityandro.moviestream.domain.data.ItemsItem
import uz.infinityandro.moviestream.presenter.adapter.StreamAdapter
import uz.infinityandro.moviestream.presenter.adapter.TrendingAdapter
import uz.infinityandro.moviestream.presenter.pages.PageDetail
import uz.infinityandro.moviestream.presenter.viewmodel.MarvelModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.MarvelModelImpl
import uz.infinityandro.moviestream.util.InternetBroadCast
import uz.infinityandro.moviestream.util.Slider
import uz.infinityandro.moviestream.utils.showToast
import java.util.*


class HomeScreen : Fragment(R.layout.screen_home) {
    private val binding by viewBinding(ScreenHomeBinding::bind)
    private lateinit var adapter: StreamAdapter
    private lateinit var adapterTrend: TrendingAdapter
    private val viewModel: MarvelModel by viewModel<MarvelModelImpl>()
    private val receiver = InternetBroadCast()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        adapterTrend = TrendingAdapter {
            val fragment = PageDetail()
            var bundle = Bundle()
            bundle.putString("salom", it.id)
            fragment.arguments = bundle
            findNavController().navigate(R.id.action_mainScreen_to_pageDetail, bundle)
        }
        adapter = StreamAdapter {
            val fragment = PageDetail()
            var bundle = Bundle()
            bundle.putString("salom", it.id)
            fragment.arguments = bundle
            findNavController().navigate(R.id.action_mainScreen_to_pageDetail, bundle)
        }
        //Auto Slide Image

        binding.bannerView.adapter = adapter
        binding.indicator.setViewPager2(binding.bannerView)
        bannerView.clipToPadding = false
        bannerView.clipChildren = false
        bannerView.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        shimmerStream.startShimmer()
        val timer = Timer()
        timer.scheduleAtFixedRate(Slider(binding.bannerView, requireActivity()), 2000, 3000)
        //Most popular movies

        trendingViewPager.adapter = adapterTrend
        trendingViewPager.clipToPadding = false
        trendingViewPager.clipChildren = false
        trendingViewPager.offscreenPageLimit = 3
        trendingViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        shimmerEffect.startShimmer()
        var composite = CompositePageTransformer()
        composite.addTransformer(MarginPageTransformer(40))
        composite.addTransformer(object : ViewPager2.PageTransformer {
            override fun transformPage(page: View, position: Float) {
                val r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }

        })

        trendingViewPager.setPageTransformer(composite)

        viewModelListeners()
        requireContext().registerReceiver(
            receiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
        requireContext().registerReceiver(receiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
        receiver.setListener {
            if (it){
                viewModel.getMostPopular()
                viewModel.getMarvel()
            }
            }
        receiver.setNetwork {
            if (it){
                viewModel.getMostPopular()
                viewModel.getMarvel()
            }
        }

    }


    private fun viewModelListeners() = with(binding) {
        viewModel.progressFlow.onEach {
            if (!it) {
                shimmerEffect.stopShimmer()
                shimmerEffect.visibility = View.GONE
                trendingViewPager.visibility = View.VISIBLE
            } else {
                shimmerEffect.startShimmer()
                shimmerEffect.visibility = View.VISIBLE
                trendingViewPager.visibility = View.GONE
            }
        }.launchIn(lifecycleScope)

        viewModel.errorMarvelFlow.onEach {
            showToast(it)
            shimmerEffect.startShimmer()
            shimmerEffect.visibility = View.VISIBLE
            shimmerStream.startShimmer()
            shimmerStream.visibility = View.VISIBLE
        }.launchIn(lifecycleScope)

        viewModel.errorMarvelDataFlow.onEach {
            showToast(it)
            shimmerEffect.startShimmer()
            shimmerEffect.visibility = View.VISIBLE
            shimmerStream.startShimmer()
            shimmerStream.visibility = View.VISIBLE
        }.launchIn(lifecycleScope)

        viewModel.dataMostPopularFlow.onEach {
            if (!it.isNullOrEmpty()) {
                adapterTrend.addFiles(it)
            }
        }.launchIn(lifecycleScope)

        viewModel.progressFlowmarvel.onEach {
            if (!it) {
                shimmerStream.stopShimmer()
                shimmerStream.visibility = View.GONE
            } else {
                shimmerStream.startShimmer()
                shimmerStream.visibility = View.VISIBLE
            }
        }.launchIn(lifecycleScope)
        viewModel.dataMarveFlow.onEach { data ->
            try {
                if (!data.isNullOrEmpty()) {
                    var item = ArrayList<ItemsItem>()
                    for (it in 0..6) {
                        item.add(data[it])
                    }
                    adapter.addFiles(item)
                }
            } catch (e: Exception) {

            }
        }.launchIn(lifecycleScope)


    }


}