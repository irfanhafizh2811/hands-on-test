package com.android.myapplication.contact.di

import BASE_URL
import DATABASE_NAME
import androidx.room.Room
import com.android.myapplication.contact.api.ContactApi
import com.android.myapplication.contact.persistence.ContactDB
import com.android.myapplication.contact.repository.ContactRepository
import com.android.myapplication.contact.ui.list.MovieListViewModel
import com.android.myapplication.contact.util.AppExecutors
import com.android.myapplication.util.LiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val apiModule = module {
    single { AppExecutors() }
    single<ContactApi> {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create(ContactApi::class.java)
    }
}

val viewModelModule = module {
    viewModel {
        val repository: ContactRepository = get()
        MovieListViewModel(
            repository,
            androidApplication()
        )
    }
}

val repositoryModule = module {
    single {
        val contactDB: ContactDB = get()
        val appExecutors: AppExecutors = get()
        val contactApi: ContactApi = get()
        ContactRepository(contactDB.contactDao, appExecutors, contactApi)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            ContactDB::class.java,
            DATABASE_NAME
        ).build()
    }
}