package uz.infinityandro.moviestream.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.PopularMovies
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.usecase.MostPopular

class MostPopularImpl(private val repository: MovieRepository):MostPopular {
    override fun getMostPopularMovie(apiKey: String): Flow<Result<PopularMovies>> =repository.getMostPopular(apiKey)
}