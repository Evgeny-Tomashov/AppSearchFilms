package com.devtomashov.appsearchfilms.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.devtomashov.appsearchfilms.data.entity.TmdbResults
import retrofit2.http.Path


interface TmdbApi {
    @GET("3/movie/{category}")
    fun getFilms(
        @Path("category") category: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<TmdbResults>
}