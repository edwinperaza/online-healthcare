package com.moriahdp.app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.R

internal class TaskAdapter(
    private val onItemClickHandler: TaskAdapterOnItemClickHandler
) : RecyclerView.Adapter<TaskAdapter.TaskAdapterViewHolder>() {

    private lateinit var taskEntities: List<TaskEntity>
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
        return TaskAdapterViewHolder(view)
    }

    override fun onBindViewHolder(
        taskAdapterViewHolder: TaskAdapterViewHolder,
        position: Int
    ) {
        val task = taskEntities[position]
        taskAdapterViewHolder.titleView.text = task.title
        taskAdapterViewHolder.descriptionView.text = task.description
        taskAdapterViewHolder.imageView.setImageResource(pictureImages[(0..taskEntities.size).random()])
    }

    fun updateTasks(tasks: List<TaskEntity>) {
        taskEntities = tasks
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return taskEntities.size
    }

    interface TaskAdapterOnItemClickHandler {
        fun onItemClick(title: String)
    }

    internal inner class TaskAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        val titleView: TextView = view.findViewById(R.id.titleView)
        val descriptionView: TextView = view.findViewById(R.id.descriptionView)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val adapterPosition = adapterPosition
            val title = taskEntities[adapterPosition].title
            onItemClickHandler.onItemClick(title)
        }
    }
}