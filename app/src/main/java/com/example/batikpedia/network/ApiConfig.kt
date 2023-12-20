package com.example.batikpedia.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {
    private const val BASE_URL = "https://batikpedia-backend-atgad6ig2a-et.a.run.app/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).build())
        .build()
    val apiInstance = retrofit.create(ApiService::class.java)
}
