package com.moriahdp.covtracker.util

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.moriahdp.covtracker.domain.model.FeedItem
import com.moriahdp.core.extension.LiveResult
import com.moriahdp.core.extension.postSuccess
import org.koin.core.KoinComponent
import org.koin.core.inject

object FirestoreFeed : KoinComponent {

    private val db: FirebaseFirestore by inject()

    fun getFeed(liveData: LiveResult<List<FeedItem>>) {
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
                liveData.postSuccess(feedList)
            }
            .addOnFailureListener { exception ->
                Log.d("EDWIN", "Error getting documents: ", exception)
            }
    }

}