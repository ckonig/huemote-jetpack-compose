package com.example.botnavc.di

import com.example.botnavc.network.DTO.config.ConfigMapper
import com.example.botnavc.network.HueService
import com.example.botnavc.repository.ConfigRepository
import com.example.botnavc.repository.ConfigRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object ConfigRepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        hueService: HueService,
        mapper: ConfigMapper,
    ): ConfigRepository{
        return ConfigRepositoryImpl(
            hueService = hueService,
            mapper = mapper
        )
    }
}