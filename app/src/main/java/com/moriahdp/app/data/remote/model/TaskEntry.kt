package com.moriahdp.app.data.remote.model

import com.moriahdp.app.domain.model.Task

data class TaskEntry(
  val id: Long,
  val title: String,
  val description: String
)

fun TaskEntry.toTask() = Task(
  id = id,
  title = title,
  description = description
)