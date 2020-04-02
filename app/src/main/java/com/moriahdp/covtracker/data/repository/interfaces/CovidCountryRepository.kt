package com.moriahdp.covtracker.data.repository.interfaces

import com.moriahdp.covtracker.data.remote.model.CovidCountryEntry

interface CovidCountryRepository {
    suspend fun getAllCovidCountry(): List<CovidCountryEntry>
}