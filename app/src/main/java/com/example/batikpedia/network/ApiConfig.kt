package com.example.batikpedia.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {

    private const val BASE_URL = "https://batikpedia-backend-staging-atgad6ig2a-et.a.run.app/api/"

    val apiInstance: ApiService = getRetrofit().create(ApiService::class.java)

    private fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()

    private fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(30, TimeUnit.SECONDS) // Adjusted timeout to 30 seconds
            .readTimeout(30, TimeUnit.SECONDS)    // Adjusted timeout to 30 seconds
            .build()
}
