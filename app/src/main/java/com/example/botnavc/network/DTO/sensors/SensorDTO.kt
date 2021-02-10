package com.example.botnavc.network.DTO.sensors

data class SensorDTO(
    val capabilities: Capabilities,
    val config: Config,
    val diversityid: String,
    val manufacturername: String,
    val modelid: String,
    val name: String,
    val productname: String,
    val recycle: Boolean,
    val state: State,
    val swupdate: Swupdate,
    val swversion: String,
    val type: String,
    val uniqueid: String
)