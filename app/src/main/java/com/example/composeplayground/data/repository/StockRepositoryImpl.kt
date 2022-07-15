package com.example.composeplayground.data.repository

import com.example.composeplayground.data.csv.CsvParser
import com.example.composeplayground.data.local.StockDatabase
import com.example.composeplayground.data.mappers.toCompanyInfo
import com.example.composeplayground.data.mappers.toCompanyListing
import com.example.composeplayground.data.mappers.toCompanyListingEntity
import com.example.composeplayground.data.remote.StockApi
import com.example.composeplayground.domain.model.CompanyInfo
import com.example.composeplayground.domain.model.CompanyListing
import com.example.composeplayground.domain.model.IntraDayInfo
import com.example.composeplayground.domain.repository.StockRepository
import com.example.composeplayground.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: StockApi,
    private val db: StockDatabase,
    private val parser: CsvParser<CompanyListing>,
    private val intraDayInfoParser: CsvParser<IntraDayInfo>,
) : StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String,
    ): Flow<Resource<List<CompanyListing>>> = flow {

        emit(Resource.Loading(true))

        val localListings = dao.searchCompanyListing(query)
        emit(Resource.Success(data = localListings.map { it.toCompanyListing() }))

        val isDbEmpty = localListings.isEmpty() && query.isBlank()
        val loadFromCache = !isDbEmpty && !fetchFromRemote

        if (loadFromCache) {
            emit(Resource.Loading(false))
            return@flow
        }

        val remoListings = try {
            val response = api.getListings()
            parser.parse(response.byteStream())
        } catch (e: HttpException) {
            emit(Resource.Error("Error"))
            null
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server"))
            null
        }

        remoListings?.let { listings ->
            dao.clearCompanyListings()
            dao.insertCompanyListings(listings.map { it.toCompanyListingEntity() })
            emit(
                Resource.Success(
                    data = dao.searchCompanyListing("").map { it.toCompanyListing() })
            )
            emit(Resource.Loading(false))
        }

    }

    override suspend fun getIntradayInfo(symbol: String): Resource<List<IntraDayInfo>> {
        return try {
            val response = api.getIntradayInfo(symbol)
            val results = intraDayInfoParser.parse(response.byteStream())
            Resource.Success(results)
        } catch (e: IOException) {
            Resource.Error(message = "Couldn't load intraday info")
        } catch (e: HttpException) {
            Resource.Error(message = "Couldn't load intraday info")
        }
    }

    override suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo> {
        return try {
            val result = api.getCompanyInfo(symbol)
            Resource.Success(result.toCompanyInfo())
        } catch(e: IOException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load company info"
            )
        } catch(e: HttpException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load company info"
            )
        }
    }

}