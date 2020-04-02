package com.moriahdp.covtracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.covtracker.R
import com.moriahdp.covtracker.domain.model.FeedItem
import com.moriahdp.covtracker.ui.adapter.viewholder.FeedViewHolder

class FeedAdapter (
    private val onItemClickListener: FeedOnClickListener
) : RecyclerView.Adapter<FeedViewHolder>() {

    private var feedItemList: List<FeedItem> = mutableListOf()

    interface FeedOnClickListener {
        fun onItemClick(url: String)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_feed, viewGroup, false)
        view.isFocusable = true
        return FeedViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return feedItemList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val item = feedItemList[position]
        holder.bind(item)
    }

    fun updateFeed(feedItemList: List<FeedItem>) {
        this.feedItemList = feedItemList
        notifyDataSetChanged()
    }
}