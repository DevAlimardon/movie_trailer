package uz.infinityandro.moviestream.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.SearchMovie

interface SearchUseCase {
    fun getSearch(apiKey:String,name:String):Flow<Result<SearchMovie>>
}