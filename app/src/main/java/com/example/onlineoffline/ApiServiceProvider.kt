package com.example.onlineoffline

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiServiceProvider {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = retrofit().create(ApiService::class.java)
}