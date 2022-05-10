package com.example.composeplayground.feature.data.remote.dto

import com.example.composeplayground.feature.data.local.entity.WordInfoEntity

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity = WordInfoEntity(
        meanings = meanings.map { it.toMeaning() },
        origin = origin,
        phonetic = phonetic,
        word = word
    )

}