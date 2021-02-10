package com.example.botnavc.network.DTO.sensors

data class Capabilities(
    val certified: Boolean,
    val inputs: List<Input>,
    val primary: Boolean
)