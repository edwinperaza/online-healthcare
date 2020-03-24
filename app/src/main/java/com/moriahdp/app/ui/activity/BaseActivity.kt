package com.moriahdp.app.ui.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.moriahdp.app.R

open class BaseActivity: AppCompatActivity() {

    protected val fm: FragmentManager = supportFragmentManager
    protected var active: Fragment? = null

    protected fun addFragment(fragment: Fragment, tag: String) {
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_container, fragment, tag)
        transaction.commitAllowingStateLoss()
        active = fragment
    }

    protected fun replaceFragmentAndAddToBackStack(fragment: Fragment, tag: String) {
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_container, fragment, tag)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
        active = fragment
    }

    protected fun addFragmentAndAddToBackStack(fragment: Fragment, tag: String) {
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_container, fragment, tag)
        transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
        active = fragment
    }

    protected fun replaceFragment(fragment: Fragment) {
        fm.beginTransaction().hide(active!!).show(fragment).commit()
        active = fragment
    }
}