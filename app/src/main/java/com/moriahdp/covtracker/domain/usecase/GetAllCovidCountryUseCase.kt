package com.moriahdp.covtracker.domain.usecase

import com.moriahdp.covtracker.data.remote.model.toCovidCountry
import com.moriahdp.covtracker.data.repository.interfaces.CovidCountryRepository
import com.moriahdp.covtracker.domain.model.CovidCountry
import com.moriahdp.core.coroutines.ResultUseCase
import kotlinx.coroutines.Dispatchers

class GetAllCovidCountryUseCase(
    private val covidCountryRepository: CovidCountryRepository
) : ResultUseCase<String, List<CovidCountry>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {

    override suspend fun executeOnBackground(params: String): List<CovidCountry> {
        val covidCountryList: MutableList<CovidCountry> = mutableListOf()
        covidCountryRepository.getAllCovidCountry().forEach {
            if (it.totalConfirmed != 0) {
                covidCountryList.add(it.toCovidCountry())
            }
        }
        return covidCountryList
    }
}