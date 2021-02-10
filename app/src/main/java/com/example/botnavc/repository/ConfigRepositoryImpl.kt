package com.example.botnavc.repository

import com.example.botnavc.domain.model.Config
import com.example.botnavc.network.DTO.config.ConfigMapper
import com.example.botnavc.network.HueService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ConfigRepositoryImpl(private val hueService: HueService, private val mapper: ConfigMapper) :
    ConfigRepository {
    override suspend fun get(): Flow<MyDataState<Config>> = flow {
        emit(MyDataState.Loading)
        try {
            val mapped = mapper.toDomainModel(hueService.getConfig())
            emit(MyDataState.Success(mapped))
        } catch (ex: Exception) {
            emit(MyDataState.Error(ex))
        }

    }
}