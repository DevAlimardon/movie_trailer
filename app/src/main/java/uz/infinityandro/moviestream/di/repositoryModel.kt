package uz.infinityandro.moviestream.di

import org.koin.dsl.module
import uz.infinityandro.moviestream.domain.repository.MovieRepository
import uz.infinityandro.moviestream.domain.repository.impl.MovieRepositoryImpl
import uz.infinityandro.moviestream.domain.usecase.*
import uz.infinityandro.moviestream.domain.usecase.impl.*

val repositoryModel = module {
    factory<MovieRepository> { MovieRepositoryImpl() }
}

val useCaseModule = module {
    factory<MarvelMovie> { MarvelMovieImpl(get()) }
    factory<MostPopular> { MostPopularImpl(get()) }
    factory<ComingUseCase> { ComingUseCaseImpl(get()) }
    factory<TopMovieUseCase> { TopMovieUseCaseImpl(get()) }
    factory<DetailUseCase> { DetailUseCaseImpl(get()) }
    factory<YouTubeUseCase> { YouTubeUseCaseImpl(get()) }
    factory<ActorsUseCase> { ActorsUseCaseImpl(get()) }
    factory<SearchUseCase> { SearchUseCaseImpl(get()) }
}