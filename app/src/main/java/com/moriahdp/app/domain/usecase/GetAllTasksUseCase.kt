package com.moriahdp.app.domain.usecase

import com.moriahdp.app.data.repository.interfaces.TaskRepository

class GetAllTasksUseCase(
    private val taskRepository: TaskRepository
) {

}