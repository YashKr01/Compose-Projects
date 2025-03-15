package com.example.composeplayground.domain.repository

import com.example.composeplayground.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}