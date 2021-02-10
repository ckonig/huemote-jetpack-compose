package com.example.botnavc.di

import com.example.botnavc.network.DTO.config.ConfigMapper
import com.example.botnavc.network.HueFinder
import com.example.botnavc.network.HueService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object HueServiceModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): ConfigMapper {
        return ConfigMapper()
    }

    @Singleton
    @Provides
    fun provideHueFinder(): HueFinder {
        return Retrofit.Builder()
            .baseUrl("https://discovery.meethue.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(HueFinder::class.java);
    }

    @Singleton
    @Provides
    fun provideHueService(
    ): HueService {
        return Retrofit.Builder()
            .baseUrl("http://192.168.178.71/api/nFes45UGlIKfOCYnREf0SfR0A-NuIfjG10yFHiBg/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(HueService::class.java);
    }
}