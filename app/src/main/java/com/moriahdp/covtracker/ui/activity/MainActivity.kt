package com.moriahdp.covtracker.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moriahdp.covtracker.R
import com.moriahdp.covtracker.ui.fragment.CovidCountryFragment
import com.moriahdp.covtracker.ui.fragment.FeedFragment
import com.moriahdp.covtracker.ui.fragment.NotificationFragment
import com.moriahdp.covtracker.ui.interfaces.FragmentHandling

class MainActivity : BaseActivity(), LifecycleOwner, FragmentHandling {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        setSupportActionBar(toolbar)

        bottomNavigation.setOnNavigationItemSelectedListener {
            getFragmentToShow(it)
            true
        }
        bottomNavigation.selectedItemId = R.id.nav_home
    }

    private fun getFragmentToShow(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.nav_home -> {
                addFragment(FeedFragment.newInstance(), "Feed")
            }
            R.id.nav_covid -> {
                addFragment(CovidCountryFragment.newInstance(), "CovidCountry")
            }
            R.id.nav_notifications -> {
                addFragment(NotificationFragment.newInstance(), "NotificationCountry")
            }
        }
    }

    override fun replaceFragmentWithBackStack(fragment: Fragment, text: String) {
        replaceFragmentAndAddToBackStack(fragment, text)
    }

    override fun addFragmentWithBackStack(fragment: Fragment, text: String) {
        addFragmentAndAddToBackStack(fragment, text)
    }

    override fun replaceFromFragment(fragment: Fragment) {
        replaceFragment(fragment)
    }
}
