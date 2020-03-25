package com.moriahdp.app.data.remote.model.covidFeed

import com.google.gson.annotations.SerializedName

class FeedMetaEntry (
    @SerializedName("code") val code: Int,
    @SerializedName("stories") val stories: FeedMetaStoriesEntry,
    @SerializedName("size") val size: Int,
    @SerializedName("timestamp") val timestamp: Int
)