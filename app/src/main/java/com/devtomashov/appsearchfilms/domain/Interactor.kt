package com.devtomashov.appsearchfilms.domain

import com.devtomashov.appsearchfilms.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}