package com.example.botnavc.network.DTO.sensors

data class Input(
    val events: List<Event>,
    val repeatintervals: List<Int>
)