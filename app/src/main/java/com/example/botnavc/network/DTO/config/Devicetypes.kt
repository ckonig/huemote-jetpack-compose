package com.example.botnavc.network.DTO.config

data class Devicetypes(
    val bridge: Boolean,
    val lights: List<Any>,
    val sensors: List<Any>
)