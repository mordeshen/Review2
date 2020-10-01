package com.e.msappsreview.di.main

import com.e.msappsreview.api.ApiService
import com.e.msappsreview.persistence.AppDatabase
import com.e.msappsreview.persistence.MainDao
import com.e.msappsreview.repository.MainRepository
import com.e.msappsreview.session.SessionManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {
    @MainScope
    @Provides
    fun provideApiService(retrofitBuilder: Retrofit.Builder): ApiService {
        return retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }

    @MainScope
    @Provides
    fun provideMainDao(db: AppDatabase): MainDao {
        return db.getMainDao()
    }

    @MainScope
    @Provides
    fun provideMainRepository(
        apiService: ApiService,
        mainDao: MainDao,
        sessionManager: SessionManager
    ): MainRepository {
        return MainRepository(
            apiService,
            mainDao,
            sessionManager
        )
    }
}