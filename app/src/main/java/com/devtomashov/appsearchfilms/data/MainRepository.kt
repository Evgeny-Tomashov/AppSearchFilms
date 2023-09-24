package com.devtomashov.appsearchfilms.data

import com.devtomashov.appsearchfilms.data.DAO.FilmDao
import com.devtomashov.appsearchfilms.data.entity.Film
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        //Запросы в БД должны быть в отдельном потоке
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): List<Film> {
        return filmDao.getCachedFilms()
    }
}