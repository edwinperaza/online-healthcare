package com.moriahdp.app.ui.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.R
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.ui.adapter.CovidCountryAdapter

class CovidCountryAdapterViewHolder(
    private val view: View,
    private val onItemClickHandler: CovidCountryAdapter.TaskAdapterOnItemClickHandler
) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val titleView: TextView = view.findViewById(R.id.titleView)
    private val descriptionView: TextView = view.findViewById(R.id.descriptionView)
    private val imageView: ImageView = view.findViewById(R.id.imageView)

    init {
        view.setOnClickListener(this)
    }

    fun bind(covidCountry: CovidCountry, image: Int) {
        titleView.text = covidCountry.country
        descriptionView.text = covidCountry.countrySlug
        imageView.setImageResource(image)
    }

    override fun onClick(v: View) {
        val adapterPosition = adapterPosition
        val title = titleView.text.toString()
        onItemClickHandler.onItemClick(title)
    }
}