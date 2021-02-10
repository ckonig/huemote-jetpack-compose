package com.example.botnavc.network.DTO.lights

data class State(
    val alert: String,
    val bri: Int,
    val colormode: String,
    val ct: Int,
    val effect: String,
    val hue: Int,
    val mode: String,
    val on: Boolean,
    val reachable: Boolean,
    val sat: Int,
    val xy: List<Double>
)