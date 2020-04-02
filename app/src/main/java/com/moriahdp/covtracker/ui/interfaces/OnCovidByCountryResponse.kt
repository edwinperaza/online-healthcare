package com.moriahdp.covtracker.ui.interfaces

import com.moriahdp.covtracker.domain.model.CovidCountry

interface OnCovidByCountryResponse {
    fun onCovidByCountryResponse(covidCountryList: MutableList<CovidCountry>)
}