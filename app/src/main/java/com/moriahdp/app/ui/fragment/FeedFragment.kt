package com.moriahdp.app.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moriahdp.app.databinding.FeedFragmentBinding
import com.moriahdp.app.domain.model.FeedItem
import com.moriahdp.app.ui.adapter.FeedAdapter
import com.moriahdp.app.ui.interfaces.OnFeedResponse
import com.moriahdp.app.util.FirestoreFeed
import com.moriahdp.app.ui.activity.WebViewActivity

class FeedFragment : BaseFragment(), FeedAdapter.FeedOnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loading: ProgressBar
    private lateinit var feedAdapter: FeedAdapter

    private var _binding: FeedFragmentBinding? = null
    private val binding get() = _binding!!

    private var listener = object : OnFeedResponse {
        override fun onItemClick(feedList: MutableList<FeedItem>) {
            feedAdapter.updateFeed(feedList)
        }
    }

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
        FirestoreFeed.getFeed(listener)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FeedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(url: String) {
//        val intentOpenUri = Intent(requireContext(), WebViewActivity::class.java)
//        intentOpenUri.putExtra(WebViewActivity.EXTRA_URL, url)
//        startActivity(intentOpenUri)
    }

    companion object {
        fun newInstance() = FeedFragment()
    }
}