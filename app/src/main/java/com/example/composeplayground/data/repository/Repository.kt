package com.example.composeplayground.data.repository

import com.example.composeplayground.domain.repository.DataStore
import com.example.composeplayground.domain.repository.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStore,
    private val remote: RemoteDataSource
) {

    fun getAllHeroes() = remote.getAllHeroes()

    suspend fun saveOnboardingState(completed: Boolean) = dataStore.saveOnboardingState(completed)

    fun readOnboardingState() = dataStore.readOnboardingState()

    fun searchHeroes(query: String) = remote.searchHeroes(query)

}