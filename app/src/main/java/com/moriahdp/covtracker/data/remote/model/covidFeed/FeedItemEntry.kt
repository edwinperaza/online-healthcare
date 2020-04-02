package com.moriahdp.covtracker.data.remote.model.covidFeed

import com.google.gson.annotations.SerializedName

data class FeedItemEntry (
    @SerializedName("author") val author: String,
    @SerializedName("publication_date") val publicationDate: String,
    @SerializedName("language") val language: String,
    @SerializedName("source") val source: String,
    @SerializedName("excerpt") val excerpt: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String
)