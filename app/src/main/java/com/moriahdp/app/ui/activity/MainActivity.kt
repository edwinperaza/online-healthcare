package com.moriahdp.app.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moriahdp.app.R
import com.moriahdp.app.ui.fragment.CovidCountryDetailFragment
import com.moriahdp.app.ui.fragment.CovidCountryFragment
import com.moriahdp.app.ui.interfaces.FragmentHandling

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
        bottomNavigation.selectedItemId = R.id.nav_covid
    }

    private fun getFragmentToShow(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.nav_home -> {
                replaceFragmentAndAddToBackStack(CovidCountryFragment.newInstance(), "CovidCountry")
            }
            R.id.nav_covid -> {
                replaceFragmentAndAddToBackStack(CovidCountryDetailFragment.newInstance("covidCountrySlug"), "CovidCountry")
            }
            R.id.nav_notifications -> {
                replaceFragmentAndAddToBackStack(CovidCountryFragment.newInstance(), "CovidCountry")
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
