package com.sunasterisk.movie19.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sunasterisk.movie19.data.model.Favorite
import com.sunasterisk.movie19.utils.Constants

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDAO

    companion object {
        private var instance: FavoriteDatabase? = null
        fun getIntance(context: Context) =
            instance ?: Room.databaseBuilder(
                context,
                FavoriteDatabase::class.java,
                Constants.DATABASE_NAME
            )
                .build()
                .also { instance = it }
    }
}
