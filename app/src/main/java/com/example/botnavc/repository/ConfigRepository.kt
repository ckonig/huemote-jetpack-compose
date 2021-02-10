package com.example.botnavc.repository

import com.example.botnavc.domain.model.Config
import kotlinx.coroutines.flow.Flow

interface ConfigRepository {
    suspend fun get() : Flow<MyDataState<Config>>
}