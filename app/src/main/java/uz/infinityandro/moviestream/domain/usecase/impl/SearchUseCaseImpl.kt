package uz.infinityandro.moviestream.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.SearchMovie
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.usecase.SearchUseCase

class SearchUseCaseImpl(private var repository: MovieRepository):SearchUseCase {
    override fun getSearch(apiKey: String, name: String): Flow<Result<SearchMovie>> =repository.getSearchedMovie(apiKey, name)
}