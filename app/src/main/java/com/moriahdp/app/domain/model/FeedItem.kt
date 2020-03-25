package com.moriahdp.app.domain.model

data class FeedItem (
    val author: String,
    val publicationDate: String,
    val language: String,
    val source: String,
    val excerpt: String,
    val title: String,
    val url: String
)