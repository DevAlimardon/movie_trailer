package uz.infinityandro.moviestream.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.infinityandro.moviestream.presenter.viewmodel.MainModel
import uz.infinityandro.moviestream.presenter.viewmodel.impl.*

val viewModel= module {
    viewModel { MainModelImpl() }
    viewModel { MarvelModelImpl(get(),get()) }
    viewModel { AnyOfMovieModelImpl(get()) }
    viewModel { ComingModelImpl(get()) }
    viewModel { TopMovieModelImpl(get()) }
    viewModel { DetailIViewModelImpl(get()) }
    viewModel { YouTubeModelImpl(get()) }
    viewModel { ActorsModelImpl(get()) }
    viewModel { SearchModelImpl(get()) }
}