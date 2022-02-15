package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.infinityandro.moviestream.domain.data.MovieDetail
import uz.infinityandro.moviestream.domain.usecase.DetailUseCase
import uz.infinityandro.moviestream.presenter.viewmodel.DetailViewModel
import uz.infinityandro.moviestream.util.Constants
import kotlin.random.Random

class DetailIViewModelImpl(private val useCase: DetailUseCase) : ViewModel(), DetailViewModel {
    override val progressFlow = MutableSharedFlow<Boolean>()
    override val dataFlow = MutableSharedFlow<MovieDetail>()
    override val errorFlow = MutableSharedFlow<String>()

    override fun getMovie(id: String) {
        useCase.getDetail(Constants.id[Random.nextInt(0,Constants.id.size)], id).onEach {
            progressFlow.emit(true)
            it.onSuccess {
                progressFlow.emit(false)
                dataFlow.emit(it)
            }.onFailure {
                errorFlow.emit(it.message.toString())
                progressFlow.emit(true)
            }
        }.launchIn(viewModelScope)
    }
}