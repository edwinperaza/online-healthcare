package com.moriahdp.app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.databinding.FeedFragmentBinding
import com.moriahdp.app.domain.model.FeedItem
import com.moriahdp.app.presentation.viewmodel.FeedViewModel
import com.moriahdp.app.ui.adapter.FeedAdapter
import com.moriahdp.core.coroutines.Result
import com.moriahdp.core.extension.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : BaseFragment(), FeedAdapter.FeedOnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loading: ProgressBar
    private lateinit var feedAdapter: FeedAdapter

    private var _binding: FeedFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FeedViewModel by viewModel()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(context)
        feedAdapter = FeedAdapter(this)
        loading = binding.loading
        recyclerView = binding.feedRecycler
            .apply {
                layoutManager = linearLayoutManager
                setHasFixedSize(true)
                adapter = feedAdapter
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FeedFragmentBinding.inflate(inflater, container, false)

        with(viewModel) {
            observe(feedItemList, ::feedObserver)
            viewModel.getFeed()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(url: String) {
    }

    private fun feedObserver(result: Result<List<FeedItem>>?) {

        when (result) {
            is Result.OnLoading -> {
                showLoading()
            }
            is Result.OnSuccess -> {
                showFeedDataView()
                feedAdapter.updateFeed(result.value)
            }
            is Result.OnError -> {

            }
            else -> {

            }
        }
    }

    private fun showFeedDataView() {
        loading.visibility = View.INVISIBLE
        recyclerView.visibility = View.VISIBLE
    }

    private fun showLoading() {
        recyclerView.visibility = View.INVISIBLE
        loading.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance() = FeedFragment()
    }
}