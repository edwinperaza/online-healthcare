package com.moriahdp.app.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moriahdp.app.domain.model.Task

@Entity(tableName = "tasks")
data class TaskEntityModel(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String
)

fun TaskEntityModel.toTask() = Task(
    id = id,
    title = title,
    description = description
)