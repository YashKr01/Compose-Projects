package com.example.composeplayground.domain.use_case.get_coins

import com.example.composeplayground.common.Resource
import com.example.composeplayground.data.remote.dto.toCoin
import com.example.composeplayground.domain.model.Coin
import com.example.composeplayground.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Some Error Occurred"))
        } catch (e: IOError) {
            emit(Resource.Error("Couldn't reach the server"))
        }
    }

}