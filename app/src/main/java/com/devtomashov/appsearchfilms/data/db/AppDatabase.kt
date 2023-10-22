package com.devtomashov.appsearchfilms.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devtomashov.appsearchfilms.data.DAO.FilmDao
import com.devtomashov.appsearchfilms.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}