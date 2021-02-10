package com.example.botnavc.network.DTO.lights

data class Capabilities(
    val certified: Boolean,
    val control: Control,
    val streaming: Streaming
)