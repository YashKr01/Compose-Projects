package com.example.composeplayground.di

import android.content.Context
import androidx.room.Room
import com.example.composeplayground.data.local.AnimeDatabase
import com.example.composeplayground.data.repository.LocalDataSourceImpl
import com.example.composeplayground.domain.repository.LocalDataSource
import com.example.composeplayground.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AnimeDatabase {
        return Room.databaseBuilder(
            context,
            AnimeDatabase::class.java,
            Constants.ANIME_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: AnimeDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(database)
    }

}