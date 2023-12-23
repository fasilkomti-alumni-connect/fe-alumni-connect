package com.example.fealumniconnect.data

import com.google.gson.annotations.SerializedName

data class News(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)

data class DataItem(

	@field:SerializedName("ket_info")
	val ketInfo: String? = null,

	@field:SerializedName("nama_info")
	val namaInfo: String? = null,

	@field:SerializedName("foto_info")
	val fotoInfo: String? = null
)
