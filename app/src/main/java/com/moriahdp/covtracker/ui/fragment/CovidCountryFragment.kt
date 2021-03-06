package com.moriahdp.covtracker.ui.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.covtracker.databinding.CovidCountryFragmentBinding
import com.moriahdp.covtracker.domain.model.CovidCountry
import com.moriahdp.covtracker.presentation.viewmodel.CovidCountryViewModel
import com.moriahdp.covtracker.ui.adapter.CovidCountryAdapter
import com.moriahdp.covtracker.ui.interfaces.FragmentHandling
import com.moriahdp.core.coroutines.Result
import com.moriahdp.core.extension.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class CovidCountryFragment : BaseFragment(), CovidCountryAdapter.CovidCountryClickListener {

    private lateinit var covidCountryAdapter: CovidCountryAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var loading: ProgressBar
    private lateinit var fragmentsCallback: FragmentHandling

    private val viewModel: CovidCountryViewModel by viewModel()

    private var _binding: CovidCountryFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(context)
        covidCountryAdapter = CovidCountryAdapter(this)

        loading = binding.loading
        recyclerView = binding.taskRecycler
            .apply {
                layoutManager = linearLayoutManager
                setHasFixedSize(true)
                adapter = covidCountryAdapter
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CovidCountryFragmentBinding.inflate(inflater, container, false)

        with(viewModel) {
            observe(covidByCountryList, ::covidCountryObserver)
            viewModel.getAllCovidDataByCountry()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun covidCountryObserver(result: Result<List<CovidCountry>>?) {

        when (result) {
            is Result.OnLoading -> {
                showLoading()
            }
            is Result.OnSuccess -> {
                showCovidCountryDataView()
                covidCountryAdapter.updateCovidCountryList(result.value)
            }
            is Result.OnError -> {

            }
            else -> {

            }
        }
    }

    private fun showCovidCountryDataView() {
        loading.visibility = View.INVISIBLE
        recyclerView.visibility = View.VISIBLE
    }

    private fun showLoading() {
        recyclerView.visibility = View.INVISIBLE
        loading.visibility = View.VISIBLE
    }

    override fun onItemClick(covidCountrySlug: String) {
//        fragmentsCallback.replaceFragmentWithBackStack(
//            CovidCountryDetailFragment.newInstance(covidCountrySlug),
//            "CovidCountryDetailFragment")
    }

    companion object {
        fun newInstance() = CovidCountryFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is Activity) {
                fragmentsCallback = context as FragmentHandling
            }
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement fragmentsCallback")
        }
    }
}