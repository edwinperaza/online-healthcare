package com.moriahdp.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.R
import com.moriahdp.app.domain.model.Task
import com.moriahdp.app.ui.adapter.viewholder.TaskAdapterViewHolder

class TaskAdapter(
    private val onItemClickHandler: TaskAdapterOnItemClickHandler
) : RecyclerView.Adapter<TaskAdapterViewHolder>() {

    private var taskEntities: List<Task> = mutableListOf()
    private val pictureImages = intArrayOf(
        R.drawable.cohete_flat,
        R.drawable.london_flat,
        R.drawable.material_flat,
        R.drawable.moon_flat,
        R.drawable.mountain_flat,
        R.drawable.mountain_mo_flat,
        R.drawable.moutain_go_flat,
        R.drawable.pine_flat,
        R.drawable.towers_flat,
        R.drawable.vulcan_flat
    )

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): TaskAdapterViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_task, viewGroup, false)
        view.isFocusable = true
        return TaskAdapterViewHolder(view, onItemClickHandler)
    }

    override fun onBindViewHolder(
        taskAdapterViewHolder: TaskAdapterViewHolder,
        position: Int
    ) {
        val task = taskEntities[position]
        taskAdapterViewHolder.bind(task, pictureImages[(0..taskEntities.size).random()])
    }

    fun updateTasks(tasks: List<Task>) {
        taskEntities = tasks
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return taskEntities.size
    }

    interface TaskAdapterOnItemClickHandler {
        fun onItemClick(title: String)
    }
}