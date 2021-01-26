package com.android.myapplication.contact

import android.app.Application
import com.android.myapplication.contact.di.apiModule
import com.android.myapplication.contact.di.databaseModule
import com.android.myapplication.contact.di.repositoryModule
import com.android.myapplication.contact.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    apiModule,
                    viewModelModule,
                    repositoryModule,
                    databaseModule
                )
            )
        }
    }
}