package com.example.composeplayground.domain.repository

import com.example.composeplayground.domain.model.CompanyListing
import com.example.composeplayground.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

}