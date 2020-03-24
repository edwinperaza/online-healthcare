package com.moriahdp.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moriahdp.app.data.local.database.CovidCountryRoomDao
import com.moriahdp.app.data.local.model.CovidCountryEntityModel

@Database(entities = [CovidCountryEntityModel::class], version = 1)
abstract class HealthCareDatabase : RoomDatabase() {

    abstract fun taskRoomDao(): CovidCountryRoomDao

    companion object {
        private var INSTANCE: HealthCareDatabase? = null

        fun getInstance(context: Context): HealthCareDatabase? {
            if (INSTANCE == null) {
                synchronized(HealthCareDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        HealthCareDatabase::class.java, "health_care.db"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}