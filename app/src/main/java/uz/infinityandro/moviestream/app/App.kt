package uz.infinityandro.moviestream.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uz.infinityandro.moviestream.di.repositoryModel
import uz.infinityandro.moviestream.di.useCaseModule
import uz.infinityandro.moviestream.di.viewModel

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(repositoryModel, viewModel, useCaseModule))
        }
        instance = this
    }
}