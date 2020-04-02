package com.moriahdp.covtracker.data.remote.model.covidFeed

import com.google.gson.annotations.SerializedName

data class FeedResponseEntry (
    @SerializedName("meta") val meta: String,
    @SerializedName("results") val results: FeedListEntry
)