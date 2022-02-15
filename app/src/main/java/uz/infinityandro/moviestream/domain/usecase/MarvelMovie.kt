package uz.infinityandro.moviestream.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.NameByMovie

interface MarvelMovie {
    fun getMarvel(apiKey:String,id:String):Flow<Result<NameByMovie>>
}