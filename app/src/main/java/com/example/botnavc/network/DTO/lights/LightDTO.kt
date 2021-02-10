package com.example.botnavc.network.DTO.lights

data class LightDTO(
    val capabilities: Capabilities,
    val config: Config,
    val manufacturername: String,
    val modelid: String,
    val name: String,
    val productid: String,
    val productname: String,
    val state: State,
    val swconfigid: String,
    val swupdate: Swupdate,
    val swversion: String,
    val type: String,
    val uniqueid: String
)