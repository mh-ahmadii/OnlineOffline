package com.example.onlineoffline

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photos")
data class Photo(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
) {
}