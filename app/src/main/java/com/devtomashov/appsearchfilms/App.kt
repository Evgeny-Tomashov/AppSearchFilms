package com.devtomashov.appsearchfilms

import android.app.Application
import com.devtomashov.appsearchfilms.di.AppComponent
import com.devtomashov.appsearchfilms.di.DaggerAppComponent
import com.devtomashov.appsearchfilms.di.DatabaseModule
import com.devtomashov.appsearchfilms.di.DomainModule
import com.devtomashov.appsearchfilms.di.RemoteModule


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}