package com.example.botnavc.di

import android.content.Context
import androidx.room.Room
import com.example.botnavc.room.CacheMapper
import com.example.botnavc.room.ConfigDao
import com.example.botnavc.room.ConfigDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideConfigDb(@ApplicationContext context: Context): ConfigDatabase {
        return Room.databaseBuilder(
            context,
            ConfigDatabase::class.java,
            ConfigDatabase.DATABASE_NAME,
        )
            .fallbackToDestructiveMigration()
            .build();
    }

    @Singleton
    @Provides
    fun provideConfigDao(configDatabase: ConfigDatabase): ConfigDao {
        return configDatabase.configDao();
    }

    @Singleton
    @Provides
    fun provideCacheMapper(): CacheMapper {
        return CacheMapper();
    }
}