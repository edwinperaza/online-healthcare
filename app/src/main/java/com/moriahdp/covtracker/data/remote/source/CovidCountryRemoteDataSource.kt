package com.moriahdp.covtracker.data.remote.source

import com.moriahdp.covtracker.data.remote.model.CovidCountryEntry
import com.moriahdp.covtracker.data.remote.net.CovidCountryService
import com.moriahdp.core.extension.await

open class CovidCountryRemoteDataSource(
    private val covidCountryService: CovidCountryService
) {
    suspend fun getServices(): List<CovidCountryEntry> {
        return covidCountryService.getAllTasksAsync().await()!!.countries
    }
}