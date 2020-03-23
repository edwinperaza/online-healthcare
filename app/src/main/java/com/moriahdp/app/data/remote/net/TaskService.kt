package com.moriahdp.app.data.remote.net

import com.moriahdp.app.data.remote.model.CovidSummary
import retrofit2.Call
import retrofit2.http.GET

interface TaskService {

  @GET("summary")
  fun getAllTasksAsync(): Call<CovidSummary>
}