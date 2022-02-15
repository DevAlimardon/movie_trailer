package uz.infinityandro.moviestream.presenter.pages

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.PageMovieBinding
import uz.infinityandro.moviestream.presenter.adapter.TopAdapter
import uz.infinityandro.moviestream.presenter.viewmodel.TopMovieModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.TopMovieModelImpl
import uz.infinityandro.moviestream.util.InternetBroadCast
import uz.infinityandro.moviestream.utils.showToast

class PageMovie:Fragment(R.layout.page_movie) {
    private val binding by viewBinding(PageMovieBinding::bind)
    private val viewModel:TopMovieModel by viewModel<TopMovieModelImpl>()
    private lateinit var adapter:TopAdapter
    private val receiver = InternetBroadCast()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)
        adapter= TopAdapter {
            val fragment=PageDetail()
            var bundle=Bundle()
            bundle.putString("salom",it.id)
            fragment.arguments=bundle
            findNavController().navigate(R.id.action_mainScreen_to_pageDetail,bundle)
        }
        shimmer.startShimmer()
        recycler.adapter = adapter
        viewModelListeners()
        viewModel.getMovie()
        requireContext().registerReceiver(
            receiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
        requireContext().registerReceiver(receiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
        receiver.setListener {
            if (it){
                viewModel.getMovie()
            }
        }
        receiver.setNetwork {
            if (it){
                viewModel.getMovie()
            }
        }
    }
    private fun viewModelListeners() = with(binding) {

        viewModel.dataFlow.onEach {
            if (!it.isNullOrEmpty()) {
                adapter.addFiles(it)
            }
        }.launchIn(lifecycleScope)

        viewModel.errorFlow.onEach {
            showToast(it)
            recycler.visibility = View.GONE
            shimmer.visibility = View.VISIBLE
            shimmer.startShimmer()
        }.launchIn(lifecycleScope)

        viewModel.progressFlow.onEach {
            if (!it) {
                shimmer.stopShimmer()
                shimmer.visibility = View.GONE
                recycler.visibility = View.VISIBLE
            } else {
                shimmer.startShimmer()
                shimmer.visibility = View.VISIBLE
                recycler.visibility = View.GONE
            }
        }.launchIn(lifecycleScope)
    }
}