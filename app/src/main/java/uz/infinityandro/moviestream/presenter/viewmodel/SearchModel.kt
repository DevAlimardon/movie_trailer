package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.SearchMovie

interface SearchModel {
    val progressFlow: Flow<Boolean>
    val dataFlow: Flow<SearchMovie>
    val errorFlow: Flow<String>

    fun getMovie(name: String)
}