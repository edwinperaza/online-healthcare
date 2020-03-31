package com.moriahdp.app.util

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.moriahdp.app.domain.model.FeedItem
import com.moriahdp.app.ui.interfaces.OnFeedResponse
import org.koin.core.KoinComponent
import org.koin.core.inject

object FirestoreFeed : KoinComponent {

    private val db: FirebaseFirestore by inject()

    fun getFeed(listener: OnFeedResponse) {
        db.collection("feeds")
            .get()
            .addOnSuccessListener { result ->
                val feedList: MutableList<FeedItem> = mutableListOf()
                for (document in result) {
                    feedList.add(
                        FeedItem(
                            document.get("author").toString(),
                            document.get("publication_date").toString(),
                            document.get("language").toString(),
                            document.get("source").toString(),
                            document.get("excerpt").toString(),
                            document.get("title").toString(),
                            document.get("url").toString()
                        )
                    )
                }
                listener.onFeedResponse(feedList)
            }
            .addOnFailureListener { exception ->
                Log.d("EDWIN", "Error getting documents: ", exception)
            }
    }

}