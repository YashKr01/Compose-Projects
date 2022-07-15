package com.example.composeplayground.di

import com.example.composeplayground.data.csv.CompanyListingParser
import com.example.composeplayground.data.csv.CsvParser
import com.example.composeplayground.data.repository.StockRepositoryImpl
import com.example.composeplayground.domain.model.CompanyListing
import com.example.composeplayground.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingParser: CompanyListingParser
    ): CsvParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        companyListingImpl: StockRepositoryImpl
    ): StockRepository

}