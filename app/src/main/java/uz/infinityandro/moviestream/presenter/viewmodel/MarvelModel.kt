package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ItemsItem
import uz.infinityandro.moviestream.domain.data.ItemsItems

interface MarvelModel {

    val progressFlow:Flow<Boolean>
    val progressFlowmarvel:Flow<Boolean>
    val dataMarveFlow:Flow<List<ItemsItem>>
    val errorMarvelFlow:Flow<String>
    val errorMarvelDataFlow:Flow<String>
    val dataMostPopularFlow:Flow<List<ItemsItems>>
    val goToFlow:Flow<Unit>

    fun getMarvel()
    fun getMostPopular()
}