package com.example.composeplayground.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.composeplayground.data.local.AnimeDatabase
import com.example.composeplayground.data.paging_source.AnimeRemoteMediator
import com.example.composeplayground.data.paging_source.SearchHeroesSource
import com.example.composeplayground.data.remote.AnimeApi
import com.example.composeplayground.domain.model.Hero
import com.example.composeplayground.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImpl(
    private val api: AnimeApi,
    private val database: AnimeDatabase
): RemoteDataSource {

    private val heroDao = database.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = 3),
            remoteMediator = AnimeRemoteMediator(api = api, database = database),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = 3),
            pagingSourceFactory = { SearchHeroesSource(api = api, query = query) }
        ).flow
    }

}