package com.moriahdp.app.data.repository.interfaces

import com.moriahdp.app.data.remote.model.CovidCountryEntry

interface CovidCountryRepository {
    suspend fun getAllCovidCountry(): List<CovidCountryEntry>
}