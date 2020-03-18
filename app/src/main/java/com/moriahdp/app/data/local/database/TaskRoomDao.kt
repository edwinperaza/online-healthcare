package com.moriahdp.app.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.moriahdp.app.data.local.model.TaskEntityModel

@Dao
interface TaskRoomDao {

    @Query("SELECT * from tasks")
    fun getAll(): List<TaskEntityModel>

    @Insert(onConflict = REPLACE)
    fun insert(weatherData: TaskEntityModel)

    @Query("DELETE from tasks")
    fun deleteAll()
}