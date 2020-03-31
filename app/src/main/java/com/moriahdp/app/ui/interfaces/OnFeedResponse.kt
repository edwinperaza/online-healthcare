package com.moriahdp.app.ui.interfaces

import com.moriahdp.app.domain.model.FeedItem

interface OnFeedResponse {
    fun onFeedResponse(feedList: MutableList<FeedItem>)
}