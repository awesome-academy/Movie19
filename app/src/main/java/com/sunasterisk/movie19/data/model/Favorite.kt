package com.sunasterisk.movie19.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorite")
data class Favorite(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "nameMovie")
    val nameMovie: String = "",
    @ColumnInfo(name = "posterPath")
    val posterPath: String = "",
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String = "",
    @ColumnInfo(name = "idMovie")
    val idMovie: Int = 0
)
