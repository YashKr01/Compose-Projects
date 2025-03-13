package com.example.composeplayground.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.composeplayground.data.remote.AnimeApi
import com.example.composeplayground.domain.model.Hero
import javax.inject.Inject

class SearchHeroesSource @Inject constructor(
    private val api: AnimeApi,
    private val query: String,
) : PagingSource<Int, Hero>() {

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {

        return try {
            val response = api.searchHeroes(name = query)
            val heroes = response.heroes

            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = response.prevPage,
                    nextKey = response.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}