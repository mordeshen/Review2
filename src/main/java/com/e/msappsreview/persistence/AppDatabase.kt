package com.e.msappsreview.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.e.msappsreview.models.MovieModel
import com.e.msappsreview.util.Converters

@Database(entities = [MovieModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMainDao(): MainDao

    companion object {
        const val DATABASE_NAME = "app_db"
    }
}