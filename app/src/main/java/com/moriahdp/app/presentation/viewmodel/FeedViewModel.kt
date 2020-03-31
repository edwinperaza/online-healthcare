package com.moriahdp.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.moriahdp.app.domain.model.FeedItem
import com.moriahdp.app.util.FirestoreFeed
import com.moriahdp.core.extension.LiveResult

class FeedViewModel : ViewModel() {

    val feedItemList = LiveResult<List<FeedItem>>()

    fun getFeed() {
        FirestoreFeed.getFeed(feedItemList)
    }

}