package com.moriahdp.covtracker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.moriahdp.covtracker.domain.model.CovidCountry
import com.moriahdp.covtracker.domain.usecase.GetAllCovidCountryUseCase
import com.moriahdp.covtracker.util.FirestoreCovidByCountry
import com.moriahdp.core.extension.LiveResult

class CovidCountryViewModel(
    private val getAllCovidCountryUseCase: GetAllCovidCountryUseCase
) : ViewModel() {

    val covidByCountryList = LiveResult<List<CovidCountry>>()

    fun getAllCovidDataByCountry() {
        FirestoreCovidByCountry.getCovidByCountry(covidByCountryList)
    }
}
