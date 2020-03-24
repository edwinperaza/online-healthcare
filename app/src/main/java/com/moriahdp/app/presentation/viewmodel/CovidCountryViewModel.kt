package com.moriahdp.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.domain.usecase.GetAllCovidCountryUseCase
import com.moriahdp.core.extension.LiveResult

class CovidCountryViewModel(
    private val getAllCovidCountryUseCase: GetAllCovidCountryUseCase
) : ViewModel() {

    val tasks = LiveResult<List<CovidCountry>>()

    fun getAllTask() {
        getAllCovidCountryUseCase.execute(
            liveData = tasks,
            params = "")
    }
}
