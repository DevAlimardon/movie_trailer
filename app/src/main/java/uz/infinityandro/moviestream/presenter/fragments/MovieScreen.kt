package uz.infinityandro.moviestream.presenter.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.ScreenMovieBinding
import uz.infinityandro.moviestream.presenter.adapter.MovieAdapter

class MovieScreen:Fragment(R.layout.screen_movie) {
private val binding by viewBinding(ScreenMovieBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=MovieAdapter(childFragmentManager,lifecycle)
        binding.viewPage.adapter=adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPage){tab, position->
            when(position){
                0->{tab.text="Movies"}
                1->{tab.text="Coming Soon"}
                2->{tab.text="Documentary"}
                3->{tab.text="Drama"}
                4->{tab.text="Fantasy"}
                5->{tab.text="Horror"}
                6->{tab.text="Action"}
                7->{tab.text="Romance"}
                else->{tab.text="Sport"}
            }

        }.attach()


    }
}