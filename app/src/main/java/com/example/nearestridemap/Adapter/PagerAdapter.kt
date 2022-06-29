package com.example.nearestridemap.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nearestridemap.Fragment.*

class PagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return Nearest()
            1-> return Upcoming_Fragment()
            2-> return Post_Fragment()
            3-> return Filter_Fragment()
            else -> return Nearest()
        }

    }
}