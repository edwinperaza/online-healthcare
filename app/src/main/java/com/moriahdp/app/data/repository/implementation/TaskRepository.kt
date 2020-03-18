package com.moriahdp.app.data.repository.implementation

import com.moriahdp.app.data.repository.interfaces.TaskRepository
import com.moriahdp.app.data.remote.source.TaskRemoteDataSource
import com.moriahdp.app.domain.model.Task

class TaskRepositoryImpl(
    private val taskRemoteDataSource: TaskRemoteDataSource
) : TaskRepository {

    override suspend fun getAllTasks(): MutableList<Task> {
        return mutableListOf(
            Task(
                1,
                "Titleasf afasdf asdfasdf a f ",
                "Description"
            ),
            Task(2, "Title", "Description"),
            Task(
                3,
                "Title",
                "Description sfasdf a dfas dfasd fasd fasd fasd fasd fasd fad f"
            ),
            Task(4, "Title", "Description"),
            Task(
                5,
                "Title",
                "Descriptionas dfas dfas dfasd fads fas f"
            ),
            Task(6, "Title", "Description"),
            Task(7, "Title", "Description")
        )
    }
}