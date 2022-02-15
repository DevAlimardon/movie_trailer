package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ItemSoon
import uz.infinityandro.moviestream.domain.data.ItemsItem

interface ComingModel {
    val progressFlow: Flow<Boolean>
    val dataFlow: Flow<List<ItemSoon>>
    val errorFlow: Flow<String>

    fun getMovie()

}