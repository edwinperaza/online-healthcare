package com.moriahdp.app.data.remote.source

import com.moriahdp.app.data.remote.model.TaskEntry
import com.moriahdp.app.data.remote.net.TaskService
import com.moriahdp.core.extension.await

open class TaskRemoteDataSource(
    private val taskService: TaskService
) {
    suspend fun getServices(): List<TaskEntry> {
        return taskService.getAllTasksAsync().await()!!.data
    }
}