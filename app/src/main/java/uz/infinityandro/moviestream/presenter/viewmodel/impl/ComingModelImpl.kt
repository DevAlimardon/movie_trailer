package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.infinityandro.moviestream.domain.data.ItemSoon
import uz.infinityandro.moviestream.domain.usecase.ComingUseCase
import uz.infinityandro.moviestream.presenter.viewmodel.ComingModel
import uz.infinityandro.moviestream.util.Constants
import kotlin.random.Random

class ComingModelImpl(private val useCase: ComingUseCase) : ViewModel(), ComingModel {
    override val progressFlow = MutableSharedFlow<Boolean>()
    override val dataFlow = MutableSharedFlow<List<ItemSoon>>()
    override val errorFlow = MutableSharedFlow<String>()

    override fun getMovie() {
        useCase.getComingSoonUse(Constants.id[Random.nextInt(0,Constants.id.size)]).onEach {
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