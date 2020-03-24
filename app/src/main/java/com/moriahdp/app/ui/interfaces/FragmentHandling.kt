package com.moriahdp.app.ui.interfaces

import androidx.fragment.app.Fragment

interface FragmentHandling {
    fun replaceFragmentWithBackStack(fragment: Fragment, text : String)
    fun addFragmentWithBackStack(fragment: Fragment, text : String)
    fun replaceFromFragment(fragment: Fragment)
}