package com.moriahdp.app.data.repository.interfaces

import com.moriahdp.app.data.remote.model.CovidCountryEntry

interface TaskRepository {
    suspend fun getAllTasks(): List<CovidCountryEntry>
}