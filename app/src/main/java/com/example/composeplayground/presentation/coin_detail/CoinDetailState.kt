package com.example.composeplayground.presentation.coin_detail

import com.example.composeplayground.domain.model.Coin
import com.example.composeplayground.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)
