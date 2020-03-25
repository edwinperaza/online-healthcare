package com.moriahdp.app.data.remote.model.covidFeed

import com.google.gson.annotations.SerializedName

data class FeedListEntry (
    @SerializedName("stories") val feedItemList: List<FeedItemEntry>
)