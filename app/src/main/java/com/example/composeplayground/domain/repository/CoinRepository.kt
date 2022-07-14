package com.example.composeplayground.domain.repository

import com.example.composeplayground.data.remote.dto.CoinDetailDto
import com.example.composeplayground.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}