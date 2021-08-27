package com.example.onlineoffline

import androidx.lifecycle.LiveData
import kotlinx.coroutines.withTimeout

class PhotoRepository(private val apiService: ApiService, private val photoDao: PhotoDao) {

    suspend fun refreshPhoto(): List<Photo>{
        val result = withTimeout(5000) {
            apiService.getPhotos()
        }
        photoDao.addPhoto(result)
        println(result.toString())
        return result
    }

    fun getPhotos(): LiveData<List<Photo>> {
        return photoDao.getPhotos()
    }
}