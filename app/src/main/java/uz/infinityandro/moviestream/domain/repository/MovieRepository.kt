package uz.infinityandro.moviestream.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.infinityandro.moviestream.domain.data.*

interface MovieRepository {

    fun getAny(apiKey:String,id:String):Flow<Result<NameByMovie>>
    fun getMostPopular(apiKey: String):Flow<Result<PopularMovies>>
    fun getYouTube(apiKey:String,id:String):Flow<Result<YouTubeData>>
    fun getComingSoon(apiKey: String):Flow<Result<ComingSoon>>
    fun getTopMovie(apiKey: String):Flow<Result<TopMovie>>
    fun getMovieDetail(apiKey: String,id: String):Flow<Result<MovieDetail>>
    fun getActorsData(apiKey: String,id: String):Flow<Result<ActorsData>>
    fun getSearchedMovie(apiKey: String,name:String):Flow<Result<SearchMovie>>


}