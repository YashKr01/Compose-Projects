package com.example.composeplayground.domain.usecases

import com.example.composeplayground.data.repository.Repository

class SearchHeroesUseCase(
    private val repository: Repository
) {

    operator fun invoke(name: String) = repository.searchHeroes(name)

}