package uz.infinityandro.moviestream.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ActorsData
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.usecase.ActorsUseCase

class ActorsUseCaseImpl(private var repository: MovieRepository):ActorsUseCase {
    override fun getData(apiKey: String, id: String): Flow<Result<ActorsData>> =repository.getActorsData(apiKey, id)
}