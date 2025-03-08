package com.example.composeplayground.data.remote

import com.example.composeplayground.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {

    @GET("/anime-x/heroes")
    suspend fun getAllHeroes(@Query("page") page: Int = 1): ApiResponse

    @GET("/anime-x/heroes/search")
    suspend fun searchHeroes(@Query("name") name: String): ApiResponse

}