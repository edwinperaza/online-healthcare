package com.moriahdp.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.domain.usecase.GetAllTasksUseCase
import com.moriahdp.core.extension.LiveResult

class TaskViewModel(
    private val getAllTasksUseCase: GetAllTasksUseCase
) : ViewModel() {

    val tasks = LiveResult<List<CovidCountry>>()

    fun getAllTask() {
        getAllTasksUseCase.execute(
            liveData = tasks,
            params = "")
    }
}
