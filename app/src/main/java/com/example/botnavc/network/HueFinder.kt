package com.example.botnavc.network

import com.example.botnavc.network.DTO.meethue.BridgeResponse
import retrofit2.http.GET

interface HueFinder {
    @GET("/")
    suspend fun findBridge(): BridgeResponse
}