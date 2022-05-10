package com.example.composeplayground.feature.data.remote.dto

import com.example.composeplayground.feature.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) {
    fun toDefinition(): Definition = Definition(
        antonyms = antonyms,
        definition = definition,
        example = example,
        synonyms = synonyms
    )

}