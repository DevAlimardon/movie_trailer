package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.infinityandro.moviestream.domain.data.ItemTop
import uz.infinityandro.moviestream.domain.usecase.TopMovieUseCase
import uz.infinityandro.moviestream.presenter.viewmodel.TopMovieModel
import uz.infinityandro.moviestream.util.Constants
import kotlin.random.Random

class TopMovieModelImpl(private val useCase: TopMovieUseCase) :ViewModel(), TopMovieModel {
    override val progressFlow = MutableSharedFlow<Boolean>()
    override val dataFlow = MutableSharedFlow<List<ItemTop>>()
    override val errorFlow = MutableSharedFlow<String>()

    override fun getMovie() {
        useCase.getTop(Constants.id[Random.nextInt(0,Constants.id.size)]).onEach {
        progressFlow.emit(true)
        it.onSuccess {
            progressFlow.emit(false)
            dataFlow.emit(it.items!!)
        }.onFailure {
            progressFlow.emit(true)
            errorFlow.emit(it.message.toString())
        }
        }.launchIn(viewModelScope)
    }

}