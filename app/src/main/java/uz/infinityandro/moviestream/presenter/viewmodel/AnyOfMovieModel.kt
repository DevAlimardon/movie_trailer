package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ItemsItem

interface AnyOfMovieModel {
    val progressFlow: Flow<Boolean>
    val dataFlow:Flow<List<ItemsItem>>
    val errorFlow:Flow<String>

    fun getMovie(name:String)


}