package com.smartherd.navigationcomponents.network

import com.smartherd.movieapp.data.list.listMovies
import com.smartherd.movieapp.data.movie.Movies
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


const val POSTER_URL =  "https://image.tmdb.org/t/p/w342"

interface Api {

    @GET("movie/{category}")
    suspend fun getMovies(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = "0aa4f63d0b77cb2e90fa035ecc4c1900"
    ): Response<Movies>

    @GET("movie/{movie_id}")
    suspend fun getMovieId(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = "0aa4f63d0b77cb2e90fa035ecc4c1900"
    ): Response<listMovies>

    companion object{
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)

        fun invoke(): Api{
            return Retrofit.Builder()
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build()
                .create(Api::class.java)
        }
    }
}