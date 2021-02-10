package com.example.botnavc.network.DTO.config

data class Swupdate(
    val checkforupdate: Boolean,
    val devicetypes: Devicetypes,
    val notify: Boolean,
    val text: String,
    val updatestate: Int,
    val url: String
)