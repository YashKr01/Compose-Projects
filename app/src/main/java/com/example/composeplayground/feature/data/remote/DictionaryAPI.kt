package com.example.composeplayground.feature.data.remote

import com.example.composeplayground.feature.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryAPI {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto>

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }

}