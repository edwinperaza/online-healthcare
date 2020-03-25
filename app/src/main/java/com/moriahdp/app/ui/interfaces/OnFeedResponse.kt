package com.moriahdp.app.ui.interfaces

import com.moriahdp.app.domain.model.FeedItem

interface OnFeedResponse {
    fun onItemClick(feedList: MutableList<FeedItem>)
}