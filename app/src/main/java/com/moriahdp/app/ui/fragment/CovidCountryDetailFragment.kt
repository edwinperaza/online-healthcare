package com.moriahdp.app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moriahdp.app.databinding.FragmentCovidCountryDetailBinding

private const val COUNTRY_SLUG = "countrySlug"

class CovidCountryDetailFragment : BaseFragment() {

    private var _binding: FragmentCovidCountryDetailBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(COUNTRY_SLUG)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCovidCountryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(countrySlug: String) =
            CovidCountryDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(COUNTRY_SLUG, countrySlug)
                }
            }
    }
}
