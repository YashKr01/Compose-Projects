package com.example.composeplayground.feature.domain.repository

import com.example.composeplayground.core.Resource
import com.example.composeplayground.feature.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>

}