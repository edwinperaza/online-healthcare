package com.moriahdp.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.domain.usecase.GetAllCovidCountryUseCase
import com.moriahdp.app.util.FirestoreCovidByCountry
import com.moriahdp.core.extension.LiveResult

class CovidCountryViewModel(
    private val getAllCovidCountryUseCase: GetAllCovidCountryUseCase
) : ViewModel() {

    val covidByCountryList = LiveResult<List<CovidCountry>>()

    fun getAllCovidDataByCountry() {
        FirestoreCovidByCountry.getCovidByCountry(covidByCountryList)
    }
}
