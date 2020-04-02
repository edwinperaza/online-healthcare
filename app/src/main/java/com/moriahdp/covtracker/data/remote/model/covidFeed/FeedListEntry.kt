package com.moriahdp.covtracker.data.remote.model.covidFeed

import com.google.gson.annotations.SerializedName

data class FeedListEntry (
    @SerializedName("stories") val feedItemList: List<FeedItemEntry>
)