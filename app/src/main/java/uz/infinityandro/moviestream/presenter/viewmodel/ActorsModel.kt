package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ActorsData

interface ActorsModel {
    val progressFlow: Flow<Boolean>
    val dataFlow: Flow<ActorsData>
    val errorFlow: Flow<String>

    fun getDataA(id: String)
}