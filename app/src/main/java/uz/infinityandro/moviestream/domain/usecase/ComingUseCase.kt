package uz.infinityandro.moviestream.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ComingSoon

interface ComingUseCase {
    fun getComingSoonUse(apiKey:String):Flow<Result<ComingSoon>>
}