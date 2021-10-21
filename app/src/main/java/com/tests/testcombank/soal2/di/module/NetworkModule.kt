package com.tests.testcombank.soal2.di.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.tests.testcombank.soal2.Constants
import com.tests.testcombank.soal2.api.APIClient
import com.tests.testcombank.soal2.api.APIs
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Module which provides all required dependencies about network
 */
@Module
@Suppress("unused")
object NetworkModule {
    /**
     * Provides the Post service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Post service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideUserApi(): APIs {
        return APIClient.getAPIsInstance().create(APIs::class.java)
    }
}