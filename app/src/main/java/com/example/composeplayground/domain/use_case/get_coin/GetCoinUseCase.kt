package com.example.composeplayground.domain.use_case.get_coin

import com.example.composeplayground.common.Resource
import com.example.composeplayground.data.remote.dto.toCoin
import com.example.composeplayground.data.remote.dto.toCoinDetail
import com.example.composeplayground.domain.model.Coin
import com.example.composeplayground.domain.model.CoinDetail
import com.example.composeplayground.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Some Error Occurred"))
        } catch (e: IOError) {
            emit(Resource.Error<CoinDetail>("Couldn't reach the server"))
        }
    }

}