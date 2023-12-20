package com.example.batikpedia.data.model

import com.google.gson.annotations.SerializedName

data class Batik(

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("references")
	val references: List<String?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("history")
	val history: String? = null
)
