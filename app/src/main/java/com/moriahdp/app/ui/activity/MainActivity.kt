package com.moriahdp.app.ui.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.moriahdp.app.R
import com.moriahdp.app.ui.fragment.CovidCountryFragment
import com.moriahdp.app.ui.interfaces.FragmentHandling

class MainActivity : BaseActivity(), LifecycleOwner, FragmentHandling {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_container,
                    CovidCountryFragment.newInstance()
                )
                .commit()
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
