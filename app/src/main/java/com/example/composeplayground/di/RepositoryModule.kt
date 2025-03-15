package com.example.composeplayground.di

import android.content.Context
import com.example.composeplayground.data.repository.DataStoreImpl
import com.example.composeplayground.data.repository.Repository
import com.example.composeplayground.domain.repository.DataStore
import com.example.composeplayground.domain.usecases.GetAllHeroesUseCase
import com.example.composeplayground.domain.usecases.GetSelectedHeroUseCase
import com.example.composeplayground.domain.usecases.ReadOnboardingUseCase
import com.example.composeplayground.domain.usecases.SaveOnboardingUseCase
import com.example.composeplayground.domain.usecases.SearchHeroesUseCase
import com.example.composeplayground.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStore {
        return DataStoreImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnboardingUseCase = SaveOnboardingUseCase(repository),
            readOnboardingUseCase = ReadOnboardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroesUseCase = GetSelectedHeroUseCase(repository)
        )
    }

}