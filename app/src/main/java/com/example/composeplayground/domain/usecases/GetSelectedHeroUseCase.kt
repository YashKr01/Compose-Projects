package com.example.composeplayground.domain.usecases

import com.example.composeplayground.data.repository.Repository
import com.example.composeplayground.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}