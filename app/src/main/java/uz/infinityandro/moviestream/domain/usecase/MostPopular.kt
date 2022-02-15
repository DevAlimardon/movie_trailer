package uz.infinityandro.moviestream.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.PopularMovies

interface MostPopular {
    fun getMostPopularMovie(apiKey:String):Flow<Result<PopularMovies>>
}