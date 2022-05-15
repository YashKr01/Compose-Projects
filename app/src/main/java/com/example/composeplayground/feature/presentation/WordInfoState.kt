package com.example.composeplayground.feature.presentation

import com.example.composeplayground.feature.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
