package uz.infinityandro.moviestream.presenter.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.ScreenMainBinding
import uz.infinityandro.moviestream.presenter.adapter.MainAdapter
import uz.infinityandro.moviestream.presenter.viewmodel.MainModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.MainModelImpl
import uz.infinityandro.moviestream.util.BottomPage

class MainScreen:Fragment(R.layout.screen_main) {
private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel:MainModel by viewModels<MainModelImpl>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding){
        super.onViewCreated(view, savedInstanceState)
        val adapter = MainAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter
        viewPager.isUserInputEnabled = false

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    viewModel.selectPagePos(BottomPage.HOME)
                }
                R.id.movie -> {
                    viewModel.selectPagePos(BottomPage.MOVIE)
                }
                R.id.search ->{
                    viewModel.selectPagePos(BottomPage.SEARCH)
                }
            }
            return@setOnItemSelectedListener true
        }
        viewModel.openSelectPosPageFlow.onEach {
            viewPager.currentItem = it.pos
        }.launchIn(lifecycleScope)


    }
}