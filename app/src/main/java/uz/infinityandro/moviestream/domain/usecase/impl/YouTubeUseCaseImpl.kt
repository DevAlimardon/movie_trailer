package uz.infinityandro.moviestream.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.YouTubeData
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.usecase.YouTubeUseCase

class YouTubeUseCaseImpl(private val repository: MovieRepository):YouTubeUseCase {
    override fun getYouTube(apiKey: String, id: String): Flow<Result<YouTubeData>> =repository.getYouTube(apiKey, id)
}