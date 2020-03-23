package com.moriahdp.app.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.moriahdp.app.data.local.model.CovidCountryEntityModel

@Dao
interface TaskRoomDao {

    @Query("SELECT * from covidCountry")
    fun getAll(): List<CovidCountryEntityModel>

    @Insert(onConflict = REPLACE)
    fun insert(covidCountry: CovidCountryEntityModel)

    @Query("DELETE from covidCountry")
    fun deleteAll()
}