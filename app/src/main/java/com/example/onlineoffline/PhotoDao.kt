package com.example.onlineoffline

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photos")
    fun getPhotos():LiveData<List<Photo>>

    @Insert(onConflict = IGNORE)
    suspend fun addPhoto(photos: List<Photo>)

}