package com.moriahdp.app.ui.interfaces

import com.moriahdp.app.domain.model.CovidCountry

interface OnCovidByCountryResponse {
    fun onCovidByCountryResponse(covidCountryList: MutableList<CovidCountry>)
}