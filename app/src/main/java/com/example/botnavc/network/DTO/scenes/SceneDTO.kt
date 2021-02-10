package com.example.botnavc.network.DTO.scenes

import com.example.botnavc.network.DTO.scenes.Appdata

data class SceneDTO(
    val appdata: Appdata,
    val group: String,
    val image: String,
    val lastupdated: String,
    val lights: List<String>,
    val locked: Boolean,
    val name: String,
    val owner: String,
    val picture: String,
    val recycle: Boolean,
    val type: String,
    val version: Int
)