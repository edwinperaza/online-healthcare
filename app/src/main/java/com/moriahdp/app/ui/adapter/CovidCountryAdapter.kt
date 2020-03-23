package com.moriahdp.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.R
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.ui.adapter.viewholder.CovidCountryAdapterViewHolder

class CovidCountryAdapter(
    private val onItemClickHandler: TaskAdapterOnItemClickHandler
) : RecyclerView.Adapter<CovidCountryAdapterViewHolder>() {

    private var covidCountryEntities: List<CovidCountry> = mutableListOf()
    private val pictureImages = intArrayOf(
        R.drawable.cohete_flat,
        R.drawable.london_flat,
        R.drawable.material_flat,
        R.drawable.moon_flat,
        R.drawable.mountain_flat,
        R.drawable.mountain_mo_flat,
        R.drawable.moutain_go_flat,
        R.drawable.pine_flat,
        R.drawable.towers_flat,
        R.drawable.vulcan_flat
    )

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CovidCountryAdapterViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_task, viewGroup, false)
        view.isFocusable = true
        return CovidCountryAdapterViewHolder(view, onItemClickHandler)
    }

    override fun onBindViewHolder(
        covidCountryAdapterViewHolder: CovidCountryAdapterViewHolder,
        position: Int
    ) {
        val task = covidCountryEntities[position]
        covidCountryAdapterViewHolder.bind(task, pictureImages[(0..5).random()])
    }

    fun updateTasks(covidCountries: List<CovidCountry>) {
        covidCountryEntities = covidCountries
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return covidCountryEntities.size
    }

    interface TaskAdapterOnItemClickHandler {
        fun onItemClick(title: String)
    }
}