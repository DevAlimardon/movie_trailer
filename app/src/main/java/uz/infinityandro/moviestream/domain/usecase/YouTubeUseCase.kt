package uz.infinityandro.moviestream.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.YouTubeData

interface YouTubeUseCase {
    fun getYouTube(apiKey:String,id:String):Flow<Result<YouTubeData>>
}