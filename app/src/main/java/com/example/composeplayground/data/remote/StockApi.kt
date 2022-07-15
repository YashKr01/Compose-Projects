package com.example.composeplayground.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(@Query("apikey") apiKey: String): ResponseBody

    companion object {
        const val API_KEY = "9M0V0QMXK124MV73"
        const val BASE_URL = "https://alphavantage.co"
    }

}