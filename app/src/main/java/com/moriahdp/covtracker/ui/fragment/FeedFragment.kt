package com.moriahdp.covtracker.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.moriahdp.covtracker.databinding.FeedFragmentBinding
import com.moriahdp.covtracker.domain.model.FeedItem
import com.moriahdp.covtracker.presentation.viewmodel.FeedViewModel
import com.moriahdp.covtracker.ui.adapter.FeedAdapter
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

        MobileAds.initialize(requireContext()) {}
        val mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
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
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
//        val anotherCustomTab = CustomTabsIntent.Builder().build()

//        val requestCode = 100
//        val intent = anotherCustomTab.intent
//        intent.setData(Uri.parse(url))
        customTabsIntent.launchUrl(requireContext(), Uri.parse(url))
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