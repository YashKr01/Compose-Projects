package com.example.composeplayground.feature.domain.usecases

import com.example.composeplayground.core.Resource
import com.example.composeplayground.feature.domain.model.WordInfo
import com.example.composeplayground.feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfoUseCase(private val repository: WordInfoRepository) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if(word.isBlank()) return flow {  }
        return repository.getWordInfo(word)
    }

}