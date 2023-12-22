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

    @GET("batik/all/")
    fun getAllBatikPattern(): Call<BatikResponse>

    @GET("batik/all")
    fun getProvinces(
        @Query("province") query: String
    ): Call<BatikResponse>

//    @GET("search/users")
//    @Headers("Authorization: token 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")
//    fun searchUserGithub(
//        @Query("province") query: String
//    ): Call<UserResponse>


}