package com.moriahdp.covtracker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.moriahdp.covtracker.domain.model.FeedItem
import com.moriahdp.covtracker.util.FirestoreFeed
import com.moriahdp.core.extension.LiveResult

class FeedViewModel : ViewModel() {

    val feedItemList = LiveResult<List<FeedItem>>()

    fun getFeed() {
        FirestoreFeed.getFeed(feedItemList)
    }

}