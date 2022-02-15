package uz.infinityandro.moviestream.domain.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.infinityandro.moviestream.util.Constants

object ApiClient {
    var retrofit: Retrofit?=null

    fun getMovie():Retrofit{
        retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.Api)
            .build()

        return retrofit!!
    }
}