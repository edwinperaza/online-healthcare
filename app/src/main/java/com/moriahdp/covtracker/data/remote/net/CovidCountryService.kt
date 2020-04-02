package com.moriahdp.covtracker.data.remote.net

import com.moriahdp.covtracker.data.remote.model.CovidSummary
import retrofit2.Call
import retrofit2.http.GET

interface CovidCountryService {

  @GET("summary")
  fun getAllTasksAsync(): Call<CovidSummary>
}