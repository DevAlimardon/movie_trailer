package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.infinityandro.moviestream.domain.data.ItemsItem
import uz.infinityandro.moviestream.domain.data.ItemsItems
import uz.infinityandro.moviestream.domain.usecase.MarvelMovie
import uz.infinityandro.moviestream.domain.usecase.MostPopular
import uz.infinityandro.moviestream.presenter.viewmodel.MarvelModel
import uz.infinityandro.moviestream.util.Constants
import kotlin.random.Random

class MarvelModelImpl(private val marvel: MarvelMovie, private val mostPopular: MostPopular) :
    ViewModel(), MarvelModel {
    override val progressFlow = MutableSharedFlow<Boolean>()
    override val progressFlowmarvel= MutableSharedFlow<Boolean>()
    override val dataMarveFlow = MutableSharedFlow<List<ItemsItem>>()
    override val errorMarvelFlow = MutableSharedFlow<String>()
    override val errorMarvelDataFlow = MutableSharedFlow<String>()
    override val dataMostPopularFlow = MutableSharedFlow<List<ItemsItems>>()
    override val goToFlow= MutableSharedFlow<Unit>()

    override fun getMarvel() {
        marvel.getMarvel(Constants.id[Random.nextInt(0,Constants.id.size)], "marvel").onEach {
            progressFlowmarvel.emit(true)
            it.onSuccess { data ->
                progressFlowmarvel.emit(false)
                dataMarveFlow.emit(data.items!!)
            }.onFailure {
                progressFlowmarvel.emit(true)
                errorMarvelDataFlow.emit(it.message.toString())
            }
        }.launchIn(viewModelScope)

    }

    override fun getMostPopular() {
        mostPopular.getMostPopularMovie(Constants.id[Random.nextInt(0,Constants.id.size)]).onEach {
            progressFlow.emit(true)
            it.onSuccess {
                progressFlow.emit(false)
                dataMostPopularFlow.emit(it.items!!)
            }.onFailure {
                progressFlow.emit(true)
                errorMarvelFlow.emit(it.message.toString())
            }
        }.launchIn(viewModelScope)
    }

}