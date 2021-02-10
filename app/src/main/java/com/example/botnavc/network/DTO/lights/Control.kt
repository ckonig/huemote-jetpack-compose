package com.example.botnavc.network.DTO.lights

data class Control(
    val colorgamut: List<List<Double>>,
    val colorgamuttype: String,
    val ct: Ct,
    val maxlumen: Int,
    val mindimlevel: Int
)