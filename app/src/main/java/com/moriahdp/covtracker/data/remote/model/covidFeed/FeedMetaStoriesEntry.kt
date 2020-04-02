package com.moriahdp.covtracker.data.remote.model.covidFeed

import com.google.gson.annotations.SerializedName

data class FeedMetaStoriesEntry (
    @SerializedName("next") val meta: String,
    @SerializedName("size") val size: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("total_size") val totalSize: Int,
    @SerializedName("count") val count: Int
)