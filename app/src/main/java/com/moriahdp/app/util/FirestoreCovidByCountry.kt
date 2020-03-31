package com.moriahdp.app.util

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.domain.model.FeedItem
import com.moriahdp.app.ui.interfaces.OnCovidByCountryResponse
import org.koin.core.KoinComponent
import org.koin.core.inject

object FirestoreCovidByCountry : KoinComponent {

    private val db: FirebaseFirestore by inject()

    fun getCovidByCountry(listener: OnCovidByCountryResponse) {
            db.collection("covidCasesByCountry")
                .orderBy("name")
                .get()
                .addOnSuccessListener { result ->
                    val feedList: MutableList<CovidCountry> = mutableListOf()
                    for (document in result) {
                        feedList.add(
                            CovidCountry(
                                1,
                                document.get("name").toString(),
                                document.get("slug").toString(),
                                document.get("newConfirmed").toString().toInt(),
                                document.get("totalConfirmed").toString().toInt(),
                                document.get("newDeaths").toString().toInt(),
                                document.get("totalDeaths").toString().toInt(),
                                document.get("newRecovered").toString().toInt(),
                                document.get("totalRecovered").toString().toInt()
                            )
                        )
                    }
                    listener.onCovidByCountryResponse(feedList)
                }
                .addOnFailureListener { exception ->
                    Log.d("EDWIN", "Error getting documents: ", exception)
                }
    }
}