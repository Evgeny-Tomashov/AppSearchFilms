package com.devtomashov.appsearchfilms.di

import com.devtomashov.appsearchfilms.data.MainRepository
import com.devtomashov.appsearchfilms.data.TmdbApi
import com.devtomashov.appsearchfilms.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) =
        Interactor(repo = repository, retrofitService = tmdbApi)
}