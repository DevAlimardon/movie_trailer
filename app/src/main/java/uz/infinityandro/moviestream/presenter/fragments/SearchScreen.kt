package uz.infinityandro.moviestream.presenter.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.ScreenSearchBinding
import uz.infinityandro.moviestream.presenter.adapter.SearchAdapter
import uz.infinityandro.moviestream.presenter.pages.PageDetail
import uz.infinityandro.moviestream.presenter.viewmodel.SearchModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.SearchModelImpl
import uz.infinityandro.moviestream.utils.showToast

class SearchScreen : Fragment(R.layout.screen_search) {
    private val binding by viewBinding(ScreenSearchBinding::bind)
    private val viewModel: SearchModel by viewModel<SearchModelImpl>()
    private lateinit var adapter: SearchAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SearchAdapter {
            val fragment = PageDetail()
            var bundle = Bundle()
            bundle.putString("salom", it.id)
            fragment.arguments = bundle
            findNavController().navigate(R.id.action_mainScreen_to_pageDetail, bundle)
        }
        recycler.adapter = adapter
        viewModellisteners()
        listeners()
    }

    private fun listeners() = with(binding) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.getMovie(query)
                    progress.visibility = View.VISIBLE
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    private fun viewModellisteners() = with(binding) {
        viewModel.dataFlow.onEach { data ->
            if (data != null) {
                if (data.results!!.size == 0) {

                } else {
                    adapter.addFiles(data.results)
                }
            }
        }.launchIn(lifecycleScope)

        viewModel.errorFlow.onEach {
            showToast(it)
        }.launchIn(lifecycleScope)

        viewModel.progressFlow.onEach {
            if (!it) {
                progress.visibility = View.GONE
            } else {
                progress.visibility = View.VISIBLE
            }
        }.launchIn(lifecycleScope)
    }
}