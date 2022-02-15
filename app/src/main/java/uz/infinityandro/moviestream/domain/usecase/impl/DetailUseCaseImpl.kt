package uz.infinityandro.moviestream.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.MovieDetail
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.usecase.DetailUseCase

class DetailUseCaseImpl(private val repository: MovieRepository):DetailUseCase {
    override fun getDetail(apiKey: String, id: String): Flow<Result<MovieDetail>> =repository.getMovieDetail(apiKey, id)
}