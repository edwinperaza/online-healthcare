package com.moriahdp.app.data.remote.source

import com.moriahdp.app.data.remote.model.CovidCountryEntry
import com.moriahdp.app.data.remote.net.CovidCountryService
import com.moriahdp.core.extension.await

open class CovidCountryRemoteDataSource(
    private val covidCountryService: CovidCountryService
) {
    suspend fun getServices(): List<CovidCountryEntry> {
        return covidCountryService.getAllTasksAsync().await()!!.countries
    }
}