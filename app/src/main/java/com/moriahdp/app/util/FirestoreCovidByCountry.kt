package com.moriahdp.app.util

import android.util.Log
import androidx.lifecycle.ComputableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.domain.model.FeedItem
import com.moriahdp.app.ui.interfaces.OnCovidByCountryResponse
import com.moriahdp.core.extension.LiveResult
import com.moriahdp.core.extension.postSuccess
import org.koin.core.KoinComponent
import org.koin.core.inject

object FirestoreCovidByCountry : KoinComponent {

    private val db: FirebaseFirestore by inject()

    fun getCovidByCountry(liveData: LiveResult<List<CovidCountry>>) {
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
                    liveData.postSuccess(feedList)
                }
                .addOnFailureListener { exception ->
                    Log.d("EDWIN", "Error getting documents: ", exception)
                }
    }
}