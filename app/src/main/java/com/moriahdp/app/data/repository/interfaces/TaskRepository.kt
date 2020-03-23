package com.moriahdp.app.data.repository.interfaces

import com.moriahdp.app.data.remote.model.TaskEntry

interface TaskRepository {
    suspend fun getAllTasks(): MutableList<TaskEntry>
}