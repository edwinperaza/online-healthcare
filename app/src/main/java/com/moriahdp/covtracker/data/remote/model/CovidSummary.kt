package com.moriahdp.covtracker.data.remote.model

import com.google.gson.annotations.SerializedName

data class CovidSummary(
    @SerializedName("Countries") val countries: List<CovidCountryEntry>
)