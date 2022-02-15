package uz.infinityandro.moviestream.domain.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.infinityandro.moviestream.domain.data.*

interface ApiService {
    @GET("API/MostPopularMovies")
    suspend fun mostPopular(@Query("apiKey") apiKey: String): Response<PopularMovies>

    @GET("en/API/Keyword")
    suspend fun anyOfMovies(
        @Query("apiKey") apiKey: String,
        @Query("id") id: String
    ): Response<NameByMovie>

    @GET("en/API/YouTubeTrailer")
    suspend fun youTube(@Query("apiKey") apiKey: String,@Query("id") id:String):Response<YouTubeData>

    @GET("en/API/ComingSoon")
    suspend fun comingSoon(@Query("apiKey") apiKey:String):Response<ComingSoon>

    @GET("en/API/Top250Movies")
    suspend fun topMovie(@Query("apikey") apiKey: String):Response<TopMovie>

    @GET("en/API/Title")
    suspend fun getMovieDetail(@Query("apiKey") apiKey: String, @Query("id") id: String,@Query("options") trailer:String):Response<MovieDetail>

    @GET("API/Name")
    suspend fun getActorsData(@Query("apiKey") apiKey: String,@Query("id") id: String):Response<ActorsData>

    @GET("en/API/SearchMovie")
    suspend fun getSearchMovie(@Query("apiKey") apiKey: String,@Query("expression") name:String):Response<SearchMovie>








}