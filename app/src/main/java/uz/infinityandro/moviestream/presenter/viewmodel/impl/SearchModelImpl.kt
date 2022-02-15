package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.infinityandro.moviestream.domain.data.SearchMovie
import uz.infinityandro.moviestream.domain.usecase.SearchUseCase
import uz.infinityandro.moviestream.presenter.viewmodel.SearchModel
import uz.infinityandro.moviestream.util.Constants
import kotlin.random.Random

class SearchModelImpl(private var useCase: SearchUseCase) : ViewModel(), SearchModel {
    override val progressFlow = MutableSharedFlow<Boolean>()
    override val dataFlow = MutableSharedFlow<SearchMovie>()
    override val errorFlow = MutableSharedFlow<String>()

    override fun getMovie(name: String) {
        useCase.getSearch(Constants.id[Random.nextInt(0,Constants.id.size)], name).onEach {
            progressFlow.emit(true)
            it.onSuccess {
                if (it!= null) {
                    progressFlow.emit(false)
                    dataFlow.emit(it)
                }
            }.onFailure {
                errorFlow.emit(it.message.toString())
                progressFlow.emit(true)
            }
        }.launchIn(viewModelScope)
    }
}