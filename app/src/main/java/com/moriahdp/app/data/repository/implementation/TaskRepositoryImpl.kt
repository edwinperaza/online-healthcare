package com.moriahdp.app.data.repository.implementation

import com.moriahdp.app.data.remote.model.CovidCountryEntry
import com.moriahdp.app.data.repository.interfaces.TaskRepository
import com.moriahdp.app.data.remote.source.TaskRemoteDataSource

class TaskRepositoryImpl(
    private val taskRemoteDataSource: TaskRemoteDataSource
) : TaskRepository {

    override suspend fun getAllTasks(): List<CovidCountryEntry> {
        return taskRemoteDataSource.getServices()
    }
}