package com.moriahdp.covtracker.data.remote.model

import com.google.gson.annotations.SerializedName
import com.moriahdp.covtracker.domain.model.CovidCountry

data class CovidCountryEntry(
  @SerializedName("Country") val country: String,
  @SerializedName("Slug") val countrySlug: String,
  @SerializedName("NewConfirmed") val newConfirmed: Int,
  @SerializedName("TotalConfirmed") val totalConfirmed: Int,
  @SerializedName("NewDeaths") val newDeaths: Int,
  @SerializedName("TotalDeaths") val totalDeaths: Int,
  @SerializedName("NewRecovered") val newRecovered: Int,
  @SerializedName("TotalRecovered") val totalRecovered: Int
)

fun CovidCountryEntry.toCovidCountry() = CovidCountry(
  id = 1,
  country = country,
  countrySlug = countrySlug,
  newConfirmed = newConfirmed,
  totalConfirmed = totalConfirmed,
  newDeaths = newDeaths,
  totalDeaths = totalDeaths,
  newRecovered = newRecovered,
  totalRecovered = totalRecovered
)