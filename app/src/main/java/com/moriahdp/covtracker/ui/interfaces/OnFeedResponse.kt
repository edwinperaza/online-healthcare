package com.moriahdp.covtracker.ui.interfaces

import com.moriahdp.covtracker.domain.model.FeedItem

interface OnFeedResponse {
    fun onFeedResponse(feedList: MutableList<FeedItem>)
}