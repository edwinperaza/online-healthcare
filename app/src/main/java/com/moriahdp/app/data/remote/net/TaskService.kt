package com.moriahdp.app.data.remote.net

import com.moriahdp.app.data.remote.model.TaskEntry
import com.moriahdp.core.base.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TaskService {

  @GET("tasks/all")
  fun getAllTasksAsync(): Call<Response<List<TaskEntry>>>

  @POST("tasks/add")
  fun addTask()

  @POST("tasks/{id}/delete")
  fun deleteTask(@Path("id") id: String)
}