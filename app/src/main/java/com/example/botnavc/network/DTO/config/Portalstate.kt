package com.example.botnavc.network.DTO.config

data class Portalstate(
    val communication: String,
    val incoming: Boolean,
    val outgoing: Boolean,
    val signedon: Boolean
)