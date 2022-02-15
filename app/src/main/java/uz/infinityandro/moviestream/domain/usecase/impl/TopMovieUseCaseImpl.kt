package uz.infinityandro.moviestream.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.TopMovie
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.usecase.TopMovieUseCase

class TopMovieUseCaseImpl(private val repository: MovieRepository):TopMovieUseCase {
    override fun getTop(apiKey: String): Flow<Result<TopMovie>> =repository.getTopMovie(apiKey)
}