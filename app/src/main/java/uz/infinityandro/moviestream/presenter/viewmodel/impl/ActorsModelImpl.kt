package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.infinityandro.moviestream.domain.data.ActorsData
import uz.infinityandro.moviestream.domain.usecase.ActorsUseCase
import uz.infinityandro.moviestream.presenter.viewmodel.ActorsModel
import uz.infinityandro.moviestream.util.Constants
import kotlin.random.Random

class ActorsModelImpl(private var useCase: ActorsUseCase) : ViewModel(), ActorsModel {
    override val progressFlow = MutableSharedFlow<Boolean>()
    override val dataFlow = MutableSharedFlow<ActorsData>()
    override val errorFlow = MutableSharedFlow<String>()

    override fun getDataA(id: String) {
        useCase.getData(Constants.id[Random.nextInt(0,Constants.id.size)], id).onEach {
            progressFlow.emit(true)
            it.onSuccess {
                progressFlow.emit(false)
                dataFlow.emit(it)
            }.onFailure {
                progressFlow.emit(true)
                errorFlow.emit(it.message.toString())
            }
        }.launchIn(viewModelScope)
    }
}