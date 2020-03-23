package com.moriahdp.app.ui.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.R
import com.moriahdp.app.domain.model.Task
import com.moriahdp.app.ui.adapter.TaskAdapter

class TaskAdapterViewHolder(
    private val view: View,
    private val onItemClickHandler: TaskAdapter.TaskAdapterOnItemClickHandler
) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val titleView: TextView = view.findViewById(R.id.titleView)
    private val descriptionView: TextView = view.findViewById(R.id.descriptionView)
    private val imageView: ImageView = view.findViewById(R.id.imageView)

    init {
        view.setOnClickListener(this)
    }

    fun bind(task: Task, image: Int) {
        titleView.text = task.title
        descriptionView.text = task.description
        imageView.setImageResource(image)
    }

    override fun onClick(v: View) {
        val adapterPosition = adapterPosition
        val title = titleView.text.toString()
        onItemClickHandler.onItemClick(title)
    }
}