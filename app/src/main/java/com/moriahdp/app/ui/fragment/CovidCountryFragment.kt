package com.moriahdp.app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.databinding.TaskFragmentBinding
import com.moriahdp.app.domain.model.CovidCountry
import com.moriahdp.app.presentation.viewmodel.TaskViewModel
import com.moriahdp.app.ui.adapter.CovidCountryAdapter
import com.moriahdp.core.coroutines.Result
import com.moriahdp.core.extension.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class CovidCountryFragment : Fragment(),
    CovidCountryAdapter.TaskAdapterOnItemClickHandler {

    private lateinit var covidCountryAdapter: CovidCountryAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var loading: ProgressBar

    private val viewModel: TaskViewModel by viewModel()

    private var _binding: TaskFragmentBinding? = null
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
        _binding = TaskFragmentBinding.inflate(inflater, container, false)

        with(viewModel) {
            observe(tasks, ::taskObserver)
            viewModel.getAllTask()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun taskObserver(result: Result<List<CovidCountry>>?) {

        when (result) {
            is Result.OnLoading -> {
                showLoading()
            }
            is Result.OnSuccess -> {
                showTasksDataView()
                covidCountryAdapter.updateTasks(result.value)
            }
            is Result.OnError -> {

            }
            else -> {

            }
        }
    }

    private fun showTasksDataView() {
        loading.visibility = View.INVISIBLE
        recyclerView.visibility = View.VISIBLE
    }

    private fun showLoading() {
        recyclerView.visibility = View.INVISIBLE
        loading.visibility = View.VISIBLE
    }

    override fun onItemClick(title: String) {

    }

    companion object {
        fun newInstance() = CovidCountryFragment()
    }
}