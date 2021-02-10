package com.example.botnavc.repository

sealed class ConfigEvent {
    object GetConfigEvent: ConfigEvent()
    object None: ConfigEvent()
}