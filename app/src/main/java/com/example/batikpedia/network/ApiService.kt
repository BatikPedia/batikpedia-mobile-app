package com.example.batikpedia.network

import com.example.batikpedia.data.model.Batik
import com.example.batikpedia.data.model.BatikResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("batik/id/{pattern}")
    fun getBatikPattern(
        @Path("pattern") pattern: String
    ): Call<Batik>

    @GET("batik/all")
    fun getAllBatikPattern(): Call<BatikResponse>

}