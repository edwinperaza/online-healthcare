package com.moriahdp.app.domain.usecase

import com.moriahdp.app.data.remote.model.toTask
import com.moriahdp.app.data.repository.interfaces.TaskRepository
import com.moriahdp.app.domain.model.Task
import com.moriahdp.core.coroutines.ResultUseCase
import kotlinx.coroutines.Dispatchers

class GetAllTasksUseCase(
    private val taskRepository: TaskRepository
) : ResultUseCase<String, List<Task>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {

    override suspend fun executeOnBackground(params: String): List<Task> {
        val taskList: MutableList<Task> = mutableListOf()
        taskRepository.getAllTasks().forEach {
            taskList.add(it.toTask())
        }
        return taskList
    }
}