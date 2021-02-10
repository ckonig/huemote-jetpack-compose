package com.example.botnavc.repository

import com.example.botnavc.domain.model.Config
import com.example.botnavc.network.DTO.config.ConfigMapper
import com.example.botnavc.network.HueService
import com.example.botnavc.room.CacheMapper
import com.example.botnavc.room.ConfigDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ConfigRepositoryImpl(
    private val hueService: HueService,
    private val mapper: ConfigMapper,
    private val cacheMapper: CacheMapper,
    private val dao: ConfigDao
) :
    ConfigRepository {
    override suspend fun get(): Flow<MyDataState<Config>> = flow {
        emit(MyDataState.Loading)
        try {
            val allCached = dao.get()
            if (allCached.isEmpty()) {
                emit(MyDataState.Success(cacheMapper.toDomainModel(allCached.first())))
            } else {
                val mapped = mapper.toDomainModel(hueService.getConfig())
                dao.insert(cacheMapper.fromDomainModel(mapped));
                emit(MyDataState.Success(mapped))
            }
        } catch (ex: Exception) {
            emit(MyDataState.Error(ex))
        }

    }
}