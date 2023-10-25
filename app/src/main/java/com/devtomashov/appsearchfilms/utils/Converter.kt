package com.devtomashov.appsearchfilms.utils

import com.devtomashov.appsearchfilms.data.entity.TmdbFilm
import com.devtomashov.appsearchfilms.data.entity.Film

object Converter {
    fun convertApiListToDtoList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(
                Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            )
            )
        }
        return result
    }
}