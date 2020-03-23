package com.moriahdp.app.domain.usecase

import com.moriahdp.app.data.remote.model.toCovidCountry
import com.moriahdp.app.data.repository.interfaces.TaskRepository
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.core.coroutines.ResultUseCase
import kotlinx.coroutines.Dispatchers

class GetAllTasksUseCase(
    private val taskRepository: TaskRepository
) : ResultUseCase<String, List<CovidCountry>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {

    override suspend fun executeOnBackground(params: String): List<CovidCountry> {
        val covidCountryList: MutableList<CovidCountry> = mutableListOf()
        taskRepository.getAllTasks().forEach {
            covidCountryList.add(it.toCovidCountry())
        }
        return covidCountryList
    }
}