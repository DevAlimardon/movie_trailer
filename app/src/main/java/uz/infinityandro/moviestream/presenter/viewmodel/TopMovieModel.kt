package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ItemTop

interface TopMovieModel {
    val progressFlow: Flow<Boolean>
    val dataFlow: Flow<List<ItemTop>>
    val errorFlow: Flow<String>

    fun getMovie()
}