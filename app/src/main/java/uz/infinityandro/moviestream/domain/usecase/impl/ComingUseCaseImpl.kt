package uz.infinityandro.moviestream.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ComingSoon
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.usecase.ComingUseCase

class ComingUseCaseImpl(private val repository: MovieRepository):ComingUseCase {
    override fun getComingSoonUse(apiKey: String): Flow<Result<ComingSoon>> =repository.getComingSoon(apiKey)
}