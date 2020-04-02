package com.moriahdp.covtracker.data.repository.implementation

import com.moriahdp.covtracker.data.remote.model.CovidCountryEntry
import com.moriahdp.covtracker.data.remote.source.CovidCountryRemoteDataSource
import com.moriahdp.covtracker.data.repository.interfaces.CovidCountryRepository

class CovidCountryRepositoryImpl(
    private val covidCountryRemoteDataSource: CovidCountryRemoteDataSource
) : CovidCountryRepository {

    override suspend fun getAllCovidCountry(): List<CovidCountryEntry> {
        return covidCountryRemoteDataSource.getServices()
    }
}