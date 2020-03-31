package com.moriahdp.app.ui.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.R
import com.moriahdp.app.domain.model.FeedItem
import com.moriahdp.app.ui.adapter.FeedAdapter

class FeedViewHolder(
    view: View,
    private val onItemClickListener: FeedAdapter.FeedOnClickListener
) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val authorAndSource: TextView = view.findViewById(R.id.feedItemAuthorAndSource)
    private val title: TextView = view.findViewById(R.id.feedItemTitle)
    private val resume: TextView = view.findViewById(R.id.feedItemResume)
    private val date: TextView = view.findViewById(R.id.feedItemDate)
    private var url = ""

    init {
        view.setOnClickListener(this)
    }

    fun bind(item: FeedItem) {
        authorAndSource.text = item.author + ", " + item.source
        title.text = item.title
        resume.text = item.excerpt
        date.text = item.publicationDate
        url = item.url
    }

    override fun onClick(v: View) {
        onItemClickListener.onItemClick(url)
    }
}