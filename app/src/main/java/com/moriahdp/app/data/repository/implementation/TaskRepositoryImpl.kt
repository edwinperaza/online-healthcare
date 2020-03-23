package com.moriahdp.app.data.repository.implementation

import com.moriahdp.app.data.remote.model.TaskEntry
import com.moriahdp.app.data.repository.interfaces.TaskRepository
import com.moriahdp.app.data.remote.source.TaskRemoteDataSource

class TaskRepositoryImpl(
    private val taskRemoteDataSource: TaskRemoteDataSource
) : TaskRepository {

    override suspend fun getAllTasks(): MutableList<TaskEntry> {
        return mutableListOf(
            TaskEntry(
                1,
                "Titleasf afasdf asdfasdf a f ",
                "Description"
            ),
            TaskEntry(2, "Title", "Description"),
            TaskEntry(
                3,
                "Title",
                "Description sfasdf a dfas dfasd fasd fasd fasd fasd fasd fad f"
            ),
            TaskEntry(4, "Title", "Description"),
            TaskEntry(
                5,
                "Title",
                "Descriptionas dfas dfas dfasd fads fas f"
            ),
            TaskEntry(6, "Title", "Description"),
            TaskEntry(7, "Title", "Description")
        )
    }
}