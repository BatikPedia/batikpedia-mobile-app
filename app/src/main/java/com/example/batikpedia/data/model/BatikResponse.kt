package com.example.batikpedia.data.model

import com.google.gson.annotations.SerializedName

data class BatikResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data:  ArrayList<Batik>
)

