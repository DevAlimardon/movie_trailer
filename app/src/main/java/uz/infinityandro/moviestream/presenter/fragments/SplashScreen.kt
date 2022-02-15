package uz.infinityandro.moviestream.presenter.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.ScreenSplashBinding
import uz.infinityandro.moviestream.presenter.adapter.SplashAdapter
import uz.infinityandro.moviestream.presenter.viewmodel.MarvelModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.MarvelModelImpl

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val binding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel: MarvelModel by viewModel<MarvelModelImpl>()
    private var adapter = SplashAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.motionBackground.adapter = adapter
        adapter.addFiles(
            listOf(
                R.drawable.prem_banner_column_3,
                R.drawable.prem_banner_column_2,
                R.drawable.prem_banner_column_1,
                R.drawable.prem_banner_column_4,
                R.drawable.prem_banner_column_5,
            )
        )
        CoroutineScope(Dispatchers.Main).launch {
            delay(2500)
            dadada()
        }

    }

    private fun dadada() {
        lifecycleScope.launchWhenResumed {
            findNavController().navigate(R.id.action_splashScreen_to_mainGraph)
        }
    }


}