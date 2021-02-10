package com.example.botnavc.network

import com.example.botnavc.network.DTO.config.ConfigResponse
import com.example.botnavc.network.DTO.lights.LightsResponse
import com.example.botnavc.network.DTO.scenes.ScenesResponse
import com.example.botnavc.network.DTO.sensors.SensorsResponse
import retrofit2.http.GET
//nFes45UGlIKfOCYnREf0SfR0A-NuIfjG10yFHiBg
interface HueService {

    @GET("lights")
    suspend fun getLights(): LightsResponse

    @GET("sensors")
    suspend fun getSensors(): SensorsResponse

    @GET("scenes")
    suspend fun getScenes(): ScenesResponse

    @GET("config")
    suspend fun getConfig(): ConfigResponse
}