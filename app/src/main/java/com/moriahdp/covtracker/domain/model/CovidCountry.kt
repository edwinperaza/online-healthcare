package com.moriahdp.covtracker.domain.model

data class CovidCountry(
    val id: Long,
    val country: String,
    val countrySlug: String,
    val newConfirmed: Int,
    val totalConfirmed: Int,
    val newDeaths: Int,
    val totalDeaths: Int,
    val newRecovered: Int,
    val totalRecovered: Int
)