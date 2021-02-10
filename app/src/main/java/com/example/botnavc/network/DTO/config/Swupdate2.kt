package com.example.botnavc.network.DTO.config

import com.example.botnavc.network.DTO.config.Autoinstall

data class Swupdate2(
    val autoinstall: Autoinstall,
    val bridge: Bridge,
    val checkforupdate: Boolean,
    val lastchange: String,
    val state: String
)