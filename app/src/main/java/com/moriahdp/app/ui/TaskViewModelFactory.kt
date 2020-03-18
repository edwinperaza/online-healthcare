package com.moriahdp.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moriahdp.app.domain.TaskTestRepository

class TaskViewModelFactory(private val repository: TaskTestRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return TaskViewModel(repository) as T
    }
}