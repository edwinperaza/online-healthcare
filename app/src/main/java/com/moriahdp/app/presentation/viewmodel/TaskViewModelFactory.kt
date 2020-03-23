package com.moriahdp.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moriahdp.app.domain.usecase.GetAllTasksUseCase

class TaskViewModelFactory(
    private val getAllTasksUseCase: GetAllTasksUseCase
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(
            getAllTasksUseCase
        ) as T
    }
}