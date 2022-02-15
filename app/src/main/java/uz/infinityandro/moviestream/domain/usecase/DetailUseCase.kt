package uz.infinityandro.moviestream.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.MovieDetail

interface DetailUseCase {
    fun getDetail(apiKey:String,id:String):Flow<Result<MovieDetail>>
}