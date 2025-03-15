package com.example.composeplayground.data.repository

import com.example.composeplayground.data.local.AnimeDatabase
import com.example.composeplayground.domain.model.Hero
import com.example.composeplayground.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    database: AnimeDatabase
): LocalDataSource {

    private val dao = database.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return dao.getSelectedHero(heroId)
    }
}