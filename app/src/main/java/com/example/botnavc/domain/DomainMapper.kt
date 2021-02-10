package com.example.botnavc.domain

interface DomainMapper<T, DomainModel> {
    fun toDomainModel(model: T): DomainModel
    fun fromDomainModel(model: DomainModel): T
}