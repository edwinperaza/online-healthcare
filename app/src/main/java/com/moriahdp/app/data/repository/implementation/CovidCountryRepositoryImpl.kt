package com.moriahdp.app.data.repository.implementation

import com.moriahdp.app.data.remote.model.CovidCountryEntry
import com.moriahdp.app.data.repository.interfaces.CovidCountryRepository
import com.moriahdp.app.data.remote.source.CovidCountryRemoteDataSource

class CovidCountryRepositoryImpl(
    private val covidCountryRemoteDataSource: CovidCountryRemoteDataSource
) : CovidCountryRepository {

    override suspend fun getAllCovidCountry(): List<CovidCountryEntry> {
        return covidCountryRemoteDataSource.getServices()
    }
}