package com.example.botnavc.network.DTO.lights

data class Config(
    val archetype: String,
    val direction: String,
    val function: String,
    val startup: Startup
)