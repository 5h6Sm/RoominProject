package com.example.room

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.roomins.R

private class CheckIn (fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ImageSlideFragment(R.drawable.slide_image1)
            1 -> ImageSlideFragment(R.drawable.slide_image2)
            else -> ImageSlideFragment(R.drawable.slide_image3)
        }
    }
    vp_slider = findViewById(R.id.vp_scroll_tutorial)

    val pagerAdapter = ScreenSlidePagerAdapter(this)
    vp_slider.adapter = pagerAdapter

}
