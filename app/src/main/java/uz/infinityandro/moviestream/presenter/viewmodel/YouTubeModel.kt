package uz.infinityandro.moviestream.presenter.viewmodel

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.YouTubeData

interface YouTubeModel {

    val progressFlow: Flow<Boolean>
    val dataFlow: Flow<YouTubeData>
    val errorFlow: Flow<String>

    fun getMovie(id: String)
}