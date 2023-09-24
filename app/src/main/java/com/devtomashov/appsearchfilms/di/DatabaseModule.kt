package com.devtomashov.appsearchfilms.di

import android.content.Context
import com.devtomashov.appsearchfilms.data.MainRepository
import com.devtomashov.appsearchfilms.data.db.DatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context) = DatabaseHelper(context)

    @Provides
    @Singleton
    fun provideRepository(databaseHelper: DatabaseHelper) = MainRepository(databaseHelper)
}