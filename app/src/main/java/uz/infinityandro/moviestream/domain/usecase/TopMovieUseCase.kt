package uz.infinityandro.moviestream.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.TopMovie

interface TopMovieUseCase {
    fun getTop(apiKey:String):Flow<Result<TopMovie>>
}