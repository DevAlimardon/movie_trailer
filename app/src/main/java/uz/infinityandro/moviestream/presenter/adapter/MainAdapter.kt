package uz.infinityandro.moviestream.presenter.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.infinityandro.moviestream.presenter.fragments.HomeScreen
import uz.infinityandro.moviestream.presenter.fragments.MovieScreen
import uz.infinityandro.moviestream.presenter.fragments.SearchScreen
import uz.infinityandro.moviestream.presenter.fragments.SettingScreen

class MainAdapter(
    private val fm: FragmentManager,
    private val lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val home = HomeScreen()
                home
            }
            1 -> {
                val movie = MovieScreen()
                movie
            }
            else -> {
                val search = SearchScreen()
                search
            }
        }
    }
}