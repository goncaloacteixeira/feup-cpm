package org.skdgt.lunchlist1

import android.content.Context
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val context: Context, fm: FragmentManager, private val tabCount: Int, private val listAdapter: ArrayAdapter<Restaurant>) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                RestaurantList(listAdapter)
            }
            1 -> {
                RestaurantDetails(listAdapter)
            }
            else -> RestaurantList(listAdapter)
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return tabCount
    }
}
