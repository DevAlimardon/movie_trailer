package uz.infinityandro.moviestream.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.NameByMovie
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.usecase.MarvelMovie

class MarvelMovieImpl(private val repository: MovieRepository):MarvelMovie {
    override fun getMarvel(apiKey: String, id: String): Flow<Result<NameByMovie>> =repository.getAny(apiKey, id)
}