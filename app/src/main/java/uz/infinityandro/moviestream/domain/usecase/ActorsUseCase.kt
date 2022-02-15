package uz.infinityandro.moviestream.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.ActorsData

interface ActorsUseCase {
    fun getData(apiKey:String,id:String):Flow<Result<ActorsData>>
}