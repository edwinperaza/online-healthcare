package com.moriahdp.app.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.moriahdp.app.ui.TaskEntity
import java.util.Arrays.asList

class TaskTestRepository {

  fun getTasks(): LiveData<List<TaskEntity>> {
    val tasksList = asList(
        TaskEntity(
            "Titleasf afasdf asdfasdf a f ",
            "Description"
        ),
        TaskEntity("Title", "Description"),
        TaskEntity(
            "Title",
            "Description sfasdf a dfas dfasd fasd fasd fasd fasd fasd fad f"
        ),
        TaskEntity("Title", "Description"),
        TaskEntity(
            "Title",
            "Descriptionas dfas dfas dfasd fads fas f"
        ),
        TaskEntity("Title", "Description"),
        TaskEntity("Title", "Description")
    )
    var tasks: MutableLiveData<List<TaskEntity>> = MutableLiveData()
    tasks.value = tasksList
    return tasks
  }
}