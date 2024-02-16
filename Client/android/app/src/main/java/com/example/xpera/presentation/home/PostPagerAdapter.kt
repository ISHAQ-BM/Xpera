package com.example.xpera.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.xpera.core.fields

class PostPagerAdapter (
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount()= fields.size

    override fun createFragment(position: Int): Fragment {

        return PostFragment()
    }

}