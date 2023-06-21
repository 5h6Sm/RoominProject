package com.example.roomins
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.room.ImageSlideFragment1
import com.example.room.ImageSlideFragment2
import com.example.room.ImageSlideFragment3

class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    val fragmentList = listOf<Fragment>(ImageSlideFragment1(), ImageSlideFragment2(), ImageSlideFragment3())
    override fun getCount(): Int = 3
    override fun getItem(position: Int): Fragment = fragmentList[position]
}

class RoominFragment : Fragment(R.layout.fragment_roomin){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View?{
        val view = inflater.inflate(R.layout.fragment_roomin, container, false)
        // Instantiate a ViewPager and a PagerAdapter.
        val mPager = view.findViewById<ViewPager>(R.id.viewPager)

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(childFragmentManager)
        mPager.adapter = pagerAdapter
        tailrec fun onBackPressed() {
            if (mPager.currentItem == 0) {
                // If the user is currently looking at the first step, allow the system to handle the
                // Back button. This calls finish() on this activity and pops the back stack.
                onBackPressed()
            } else {
                // Otherwise, select the previous step.
                mPager.currentItem = mPager.currentItem - 1
            }
        }

        return view
    }
}
