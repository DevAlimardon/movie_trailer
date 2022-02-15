package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.MovieDetail

interface DetailViewModel {
    val progressFlow: Flow<Boolean>
    val dataFlow: Flow<MovieDetail>
    val errorFlow: Flow<String>

    fun getMovie(id: String)
}