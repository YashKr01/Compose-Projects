package com.example.composeplayground.feature.data.repository

import com.example.composeplayground.core.Resource
import com.example.composeplayground.feature.data.local.WordInfoDao
import com.example.composeplayground.feature.data.remote.DictionaryAPI
import com.example.composeplayground.feature.domain.model.WordInfo
import com.example.composeplayground.feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(private val api: DictionaryAPI, private val dao: WordInfoDao) :
    WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {

        emit(Resource.Loading())

        val wordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfo))

        try {
            val remoteWordInfo = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfo.map { it.word })
            dao.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error("Something went wrong", data = wordInfo))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server", data = wordInfo))
        }

        val newWordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))

    }

}