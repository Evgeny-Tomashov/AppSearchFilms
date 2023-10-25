package com.devtomashov.appsearchfilms.data

import com.devtomashov.appsearchfilms.data.DAO.FilmDao
import com.devtomashov.appsearchfilms.data.entity.Film
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> =
        filmDao.getCachedFilms()

    fun clearDb() {
        filmDao.clearFilms()
    }
}