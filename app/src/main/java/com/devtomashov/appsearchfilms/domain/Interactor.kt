package com.devtomashov.appsearchfilms.domain

import androidx.lifecycle.LiveData
import com.devtomashov.appsearchfilms.data.API
import com.devtomashov.appsearchfilms.data.entity.TmdbResultsDto
import com.devtomashov.appsearchfilms.data.MainRepository
import com.devtomashov.appsearchfilms.data.PreferenceProvider
import com.devtomashov.appsearchfilms.data.TmdbApi
import com.devtomashov.appsearchfilms.data.entity.Film
import com.devtomashov.appsearchfilms.utils.Converter
import com.devtomashov.appsearchfilms.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
    //В конструктор мы будем передавать коллбэк из вью модели, чтобы реагировать на то, когда фильмы будут получены
    //и страницу, которую нужно загрузить (это для пагинации)
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResultsDto> {
            override fun onResponse(call: Call<TmdbResultsDto>, response: Response<TmdbResultsDto>) {
                //При успехе мы вызываем метод, передаем onSuccess и в этот коллбэк список фильмов
                val list = Converter.convertApiListToDtoList(response.body()?.tmdbFilms)
                //Кладем фильмы в бд
                list.forEach {
                    repo.putToDb(list)
                }
                callback.onSuccess()
            }

            override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
            }
        })
    }
    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }
    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()

    fun getFilmsFromDB(): LiveData<List<Film>> = repo.getAllFromDB()

}