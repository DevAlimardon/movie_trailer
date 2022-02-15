package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.infinityandro.moviestream.domain.data.ItemsItem
import uz.infinityandro.moviestream.domain.usecase.MarvelMovie
import uz.infinityandro.moviestream.presenter.viewmodel.AnyOfMovieModel
import uz.infinityandro.moviestream.util.Constants
import kotlin.random.Random

class AnyOfMovieModelImpl(private val usecase:MarvelMovie):ViewModel(),AnyOfMovieModel {
    override val progressFlow= MutableSharedFlow<Boolean>()
    override val dataFlow= MutableSharedFlow<List<ItemsItem>>()
    override val errorFlow= MutableSharedFlow<String>()

    override fun getMovie(name: String) {
        usecase.getMarvel(Constants.id[Random.nextInt(0,Constants.id.size)],name).onEach {
            progressFlow.emit(true)
            it.onSuccess {
                progressFlow.emit(false)
                dataFlow.emit(it.items!!)
            }.onFailure {
                errorFlow.emit(it.message.toString())
                progressFlow.emit(true)
            }
        }.launchIn(viewModelScope)
    }
}