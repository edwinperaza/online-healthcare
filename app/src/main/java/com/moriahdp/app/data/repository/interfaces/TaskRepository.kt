package com.moriahdp.app.data.repository.interfaces

import com.moriahdp.app.domain.model.Task

interface TaskRepository {
    suspend fun getAllTasks(): MutableList<Task>
}