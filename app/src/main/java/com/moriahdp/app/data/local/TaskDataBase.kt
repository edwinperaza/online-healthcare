package com.moriahdp.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moriahdp.app.data.local.database.TaskRoomDao
import com.moriahdp.app.data.local.model.TaskEntityModel

@Database(entities = [TaskEntityModel::class], version = 1)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun taskRoomDao(): TaskRoomDao

    companion object {
        private var INSTANCE: TaskDataBase? = null

        fun getInstance(context: Context): TaskDataBase? {
            if (INSTANCE == null) {
                synchronized(TaskDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDataBase::class.java, "tasks.db"
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