package com.moriahdp.app.ui.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.R
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.ui.adapter.CovidCountryAdapter
import com.moriahdp.app.util.getFlagUrlByCountry
import com.squareup.picasso.Picasso

class CovidCountryAdapterViewHolder(
    view: View,
    private val onItemClickListener: CovidCountryAdapter.CovidCountryClickListener
) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val countryLabel: TextView = view.findViewById(R.id.countryLabel)
    private val totalConfirmedValue: TextView = view.findViewById(R.id.totalConfirmedValue)
    private val totalDeathValue: TextView = view.findViewById(R.id.totalDeathsValue)
    private val totalRecoveredValue: TextView = view.findViewById(R.id.totalRecoveredValue)
    private val imageView: ImageView = view.findViewById(R.id.countryFlagImage)
    private var countrySlug = ""

    init {
        view.setOnClickListener(this)
    }

    fun bind(covidCountry: CovidCountry) {
        countryLabel.text = covidCountry.country
        totalConfirmedValue.text = covidCountry.totalConfirmed.toString()
        totalDeathValue.text = covidCountry.totalDeaths.toString()
        totalRecoveredValue.text = covidCountry.totalRecovered.toString()
        Picasso.get().load(getFlagUrlByCountry(covidCountry.countrySlug)).into(imageView)
        countrySlug = covidCountry.countrySlug
    }

    override fun onClick(v: View) {
        onItemClickListener.onItemClick(countrySlug)
    }
}