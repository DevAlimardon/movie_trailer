package uz.infinityandro.moviestream.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.infinityandro.moviestream.domain.data.YouTubeData
import uz.infinityandro.moviestream.domain.usecase.YouTubeUseCase
import uz.infinityandro.moviestream.presenter.viewmodel.YouTubeModel
import uz.infinityandro.moviestream.util.Constants
import kotlin.random.Random

class YouTubeModelImpl(private val useCase:YouTubeUseCase):ViewModel(),YouTubeModel {
    override val progressFlow= MutableSharedFlow<Boolean>()
    override val dataFlow= MutableSharedFlow<YouTubeData>()
    override val errorFlow= MutableSharedFlow<String>()

    override fun getMovie(id: String) {
        useCase.getYouTube(Constants.id[Random.nextInt(0,Constants.id.size)],id).onEach {
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