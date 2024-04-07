package com.jantiojo.guidomia.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jantiojo.guidomia.data.model.Car
import com.jantiojo.guidomia.utils.json.ListConverters

@Database(entities = [Car::class], version = 1, exportSchema = false)
@TypeConverters(ListConverters::class)
abstract class GuidomiaAppDataBase : RoomDatabase() {

    abstract fun guidomiaDao() : GuidomiaDao


    companion object {

        @Volatile
        private var Instance: GuidomiaAppDataBase? = null

        fun getDatabase(context: Context): GuidomiaAppDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, GuidomiaAppDataBase::class.java, "Guidomia")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}