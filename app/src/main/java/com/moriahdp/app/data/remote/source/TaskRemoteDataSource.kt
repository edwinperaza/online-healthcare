package com.moriahdp.app.data.remote.source

import com.moriahdp.app.data.remote.model.CovidCountryEntry
import com.moriahdp.app.data.remote.net.TaskService
import com.moriahdp.core.extension.await

open class TaskRemoteDataSource(
    private val taskService: TaskService
) {
    suspend fun getServices(): List<CovidCountryEntry> {
        return taskService.getAllTasksAsync().await()!!.countries
    }
}