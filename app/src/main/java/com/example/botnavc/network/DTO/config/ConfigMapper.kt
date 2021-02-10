package com.example.botnavc.network.DTO.config

import com.example.botnavc.domain.DomainMapper
import com.example.botnavc.domain.model.Config

class ConfigMapper : DomainMapper<ConfigResponse, Config> {
    override fun toDomainModel(model: ConfigResponse): Config {
        return Config(model.ipaddress, model.name, model.modelid, model.localtime, model.timezone, model.mac)
    }

    override fun fromDomainModel(model: Config): ConfigResponse {
        TODO("Not yet implemented")
    }

}