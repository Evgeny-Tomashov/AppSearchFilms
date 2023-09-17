package com.devtomashov.appsearchfilms.di

import com.devtomashov.appsearchfilms.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}