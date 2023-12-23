package com.example.fealumniconnect.Network

import com.example.fealumniconnect.data.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getAllNews() : Call<News>
}