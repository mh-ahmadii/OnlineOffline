package com.example.onlineoffline

import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}