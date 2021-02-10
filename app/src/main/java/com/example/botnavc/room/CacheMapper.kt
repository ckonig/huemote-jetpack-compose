package com.example.botnavc.room

import com.example.botnavc.domain.DomainMapper
import com.example.botnavc.domain.model.Config
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : DomainMapper<ConfigCacheEntity, Config> {
    override fun toDomainModel(model: ConfigCacheEntity): Config {
        return Config(
            ipaddress = model.ipaddress,
            timezone = model.timezone,
            localtime = model.localtime,
            model = model.model,
            name = model.name,
            mac = model.mac,
        )
    }

    override fun fromDomainModel(model: Config): ConfigCacheEntity {
        return ConfigCacheEntity(
            ipaddress = model.ipaddress,
            timezone = model.timezone,
            localtime = model.localtime,
            model = model.model,
            name = model.name,
            mac = model.mac,
        )
    }
}