package uz.infinityandro.moviestream.presenter.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.infinityandro.moviestream.presenter.pages.*

class MovieAdapter(
    private val fm: FragmentManager,
    private val lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 9
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {

                val movie = PageMovie()
                movie
            }

            1 -> {
                val coming = PageComingSoon()
                coming
            }
            2 -> {
                val documentary = PageDocumentary()
                documentary
            }
            3 -> {
                val drama = PageDrama()
                drama
            }
            4 -> {
                val fantasy = PageFantasy()
                fantasy
            }
            5 -> {
                val horror = PageHorror()
                horror
            }
            6 -> {
                val action = PageAction()
                action
            }
            7 -> {
                val romance = PageRomance()
                romance
            }
            else -> {
                val sport = PageSport()
                sport
            }

        }
    }
}