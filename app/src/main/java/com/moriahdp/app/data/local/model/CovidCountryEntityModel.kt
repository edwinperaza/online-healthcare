package com.moriahdp.app.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moriahdp.app.domain.model.CovidCountry

@Entity(tableName = "covidCountry")
data class CovidCountryEntityModel(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "country") var country: String,
    @ColumnInfo(name = "countrySlug") var countrySlug: String,
    @ColumnInfo(name = "newConfirmed") var newConfirmed: Int,
    @ColumnInfo(name = "totalConfirmed") var totalConfirmed: Int,
    @ColumnInfo(name = "newDeaths") var newDeaths: Int,
    @ColumnInfo(name = "totalDeaths") var totalDeaths: Int,
    @ColumnInfo(name = "newRecovered") var newRecovered: Int,
    @ColumnInfo(name = "totalRecovered") var totalRecovered: Int
)

fun CovidCountryEntityModel.toCovidCountry() = CovidCountry(
    id = id,
    country = country,
    countrySlug = countrySlug,
    newConfirmed = newConfirmed,
    totalConfirmed = totalConfirmed,
    newDeaths = newDeaths,
    totalDeaths = totalDeaths,
    newRecovered = newRecovered,
    totalRecovered = newRecovered
)