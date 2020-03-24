package com.moriahdp.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.R
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.ui.adapter.viewholder.CovidCountryAdapterViewHolder

class CovidCountryAdapter(
    private val onItemClickListener: CovidCountryClickListener
) : RecyclerView.Adapter<CovidCountryAdapterViewHolder>() {

    private var covidCountryEntities: List<CovidCountry> = mutableListOf()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CovidCountryAdapterViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_covid_country, viewGroup, false)
        view.isFocusable = true
        return CovidCountryAdapterViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(
        covidCountryAdapterViewHolder: CovidCountryAdapterViewHolder,
        position: Int
    ) {
        val task = covidCountryEntities[position]
        covidCountryAdapterViewHolder.bind(task)
    }

    fun updateTasks(covidCountries: List<CovidCountry>) {
        covidCountryEntities = covidCountries
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return covidCountryEntities.size
    }

    interface CovidCountryClickListener {
        fun onItemClick(covidCountrySlug: String)
    }
}