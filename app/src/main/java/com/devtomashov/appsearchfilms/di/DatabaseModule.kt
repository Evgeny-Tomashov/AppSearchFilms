package com.devtomashov.appsearchfilms.di

import android.content.Context
import androidx.room.Room
import com.devtomashov.appsearchfilms.data.DAO.FilmDao
import com.devtomashov.appsearchfilms.data.MainRepository
import com.devtomashov.appsearchfilms.data.db.AppDatabase
import com.devtomashov.appsearchfilms.data.db.DatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}