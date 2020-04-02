package com.moriahdp.covtracker.ui.fragment

import androidx.fragment.app.Fragment
import com.moriahdp.covtracker.R

open class BaseFragment : Fragment() {

    fun newFragment(fragment: Fragment, tag: String) {
        val currentFragment = getCurrentFragment()
        val manager = parentFragmentManager
        val transaction = manager.beginTransaction()
        transaction.hide(currentFragment!!).replace(R.id.main_container, fragment, tag)
        transaction.addToBackStack(currentFragment.tag)
        transaction.commit()
    }

    private fun getCurrentFragment(): Fragment? {
        return parentFragmentManager.findFragmentById(R.id.main_container)
    }

}