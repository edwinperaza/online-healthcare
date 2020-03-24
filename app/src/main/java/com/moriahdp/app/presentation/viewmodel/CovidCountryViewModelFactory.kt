package com.moriahdp.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moriahdp.app.domain.usecase.GetAllCovidCountryUseCase

class CovidCountryViewModelFactory(
    private val getAllCovidCountryUseCase: GetAllCovidCountryUseCase
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CovidCountryViewModel(
            getAllCovidCountryUseCase
        ) as T
    }
}