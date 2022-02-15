package uz.infinityandro.moviestream.presenter.pages

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.PageActorsBinding
import uz.infinityandro.moviestream.presenter.adapter.BestMovieAdapter
import uz.infinityandro.moviestream.presenter.viewmodel.ActorsModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.ActorsModelImpl
import uz.infinityandro.moviestream.util.InternetBroadCast
import uz.infinityandro.moviestream.utils.showToast

class PageActors : Fragment(R.layout.page_actors) {
    private val binding by viewBinding(PageActorsBinding::bind)
    private val viewModel: ActorsModel by viewModel<ActorsModelImpl>()
    private var adapter = BestMovieAdapter()
    private val receiver = InternetBroadCast()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        recycler.adapter = adapter
        shimmer.startShimmer()
        viewModelListeners()
        val a = arguments?.get("id")
        requireContext().registerReceiver(
            receiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
        requireContext().registerReceiver(receiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
        receiver.setListener {
            if (it){
                viewModel.getDataA(a.toString())
            }
        }
        receiver.setNetwork {
            if (it){
                viewModel.getDataA(a.toString())
            }
        }
    }

    private fun viewModelListeners() = with(binding) {
        viewModel.dataFlow.onEach {
            if (it != null) {
                Glide.with(requireContext()).load(it.image).into(imageActor)
                role.setText(it.role)
                nameActor.setText(it.name)
                birthDate.text = "BirthDate: ${it.birthDate}"
                summary.setText(it.summary)
                adapter.addFiles(it.knownFor!!)
            }
        }.launchIn(lifecycleScope)

        viewModel.errorFlow.onEach {
            showToast(it)
        }.launchIn(lifecycleScope)

        viewModel.progressFlow.onEach {
            if (!it) {
                shimmer.stopShimmer()
                shimmer.visibility=View.GONE
                layout.visibility=View.VISIBLE
            } else {
                shimmer.startShimmer()
                shimmer.visibility=View.VISIBLE
                layout.visibility=View.GONE
            }
        }.launchIn(lifecycleScope)
    }
}