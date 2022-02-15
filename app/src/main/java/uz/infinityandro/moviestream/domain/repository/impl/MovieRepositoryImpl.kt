package uz.infinityandro.moviestream.domain.repository.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.infinityandro.moviestream.domain.api.ApiClient
import uz.infinityandro.moviestream.domain.api.ApiService
import uz.infinityandro.moviestream.domain.data.*
import uz.infinityandro.moviestream.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override fun getAny(apiKey: String, id: String): Flow<Result<NameByMovie>> = flow {
        try {
            val response = ApiClient.getMovie().create(ApiService::class.java).anyOfMovies(apiKey, id)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure<NameByMovie>(Throwable(response.message())))
            }
        } catch (e: Exception) {
            emit(Result.failure<NameByMovie>(Throwable("No Internet Connection")))
        }
    }

    override fun getMostPopular(apiKey: String): Flow<Result<PopularMovies>> = flow {

        try {
            val response = ApiClient.getMovie().create(ApiService::class.java).mostPopular(apiKey)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure<PopularMovies>(Throwable(response.message().toString())))
            }
        } catch (e: Exception) {
            emit(Result.failure<PopularMovies>(Throwable("No Internet Connection")))
        }
    }

    override fun getYouTube(apiKey: String, id: String): Flow<Result<YouTubeData>> = flow {
        try {
            val response = ApiClient.getMovie().create(ApiService::class.java).youTube(apiKey, id)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure<YouTubeData>(Throwable(response.message().toString())))
            }
        } catch (e: Exception) {
            emit(Result.failure<YouTubeData>(Throwable("No Internet Connection")))
        }
    }

    override fun getComingSoon(apiKey: String): Flow<Result<ComingSoon>> = flow{
        try {
            val response = ApiClient.getMovie().create(ApiService::class.java).comingSoon(apiKey)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure<ComingSoon>(Throwable(response.message().toString())))
            }
        } catch (e: Exception) {
            emit(Result.failure<ComingSoon>(Throwable("No Internet Connection")))
        }
    }

    override fun getTopMovie(apiKey: String): Flow<Result<TopMovie>> = flow{
        try {
            val response = ApiClient.getMovie().create(ApiService::class.java).topMovie(apiKey)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure<TopMovie>(Throwable(response.message().toString())))
            }
        } catch (e: Exception) {
            emit(Result.failure<TopMovie>(Throwable("No Internet Connection")))
        }
    }

    override fun getMovieDetail(apiKey: String, id: String): Flow<Result<MovieDetail>> = flow{
        try {
            val response = ApiClient.getMovie().create(ApiService::class.java).getMovieDetail(apiKey, id,"Trailer")
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure<MovieDetail>(Throwable(response.message().toString())))
            }
        } catch (e: Exception) {
            emit(Result.failure<MovieDetail>(Throwable("No Internet Connection")))
        }
    }

    override fun getActorsData(apiKey: String, id: String): Flow<Result<ActorsData>> = flow{
        try {
            val response = ApiClient.getMovie().create(ApiService::class.java).getActorsData(apiKey, id)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure<ActorsData>(Throwable(response.message().toString())))
            }
        } catch (e: Exception) {
            emit(Result.failure<ActorsData>(Throwable("No Internet Connection")))
        }
    }

    override fun getSearchedMovie(apiKey: String, name: String): Flow<Result<SearchMovie>> = flow{
        try {
            val response = ApiClient.getMovie().create(ApiService::class.java).getSearchMovie(apiKey, name)
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure<SearchMovie>(Throwable(response.message().toString())))
            }
        } catch (e: Exception) {
            emit(Result.failure<SearchMovie>(Throwable("No Internet Connection")))
        }
    }
}