//package com.example.room
//
//import android.app.Activity
//import android.os.Bundle
//import android.util.Log
//import android.widget.FrameLayout
//import android.widget.ToggleButton
//import androidx.appcompat.app.AppCompatActivity
//import androidx.viewpager2.widget.ViewPager2
//import com.example.roomins.R
//import com.example.roomins.databinding.ActivityMainBinding
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import androidx.fragment.app.Fragment
//import androidx.viewbinding.ViewBinding
//
//
//class CheckIn : Activity() {
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var navigationView: BottomNavigationView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_checkin)
//
//        navigationView.setOnItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.navigation_service -> {
//                    // 알림 탭을 선택한 경우 처리할 로직을 작성합니다.
//                    true
//                }
//                R.id.navigation_home -> {
//                    // 홈 탭을 선택한 경우 처리할 로직을 작성합니다.
//                    true
//                }
//                R.id.navigation_roomin -> {
//                    // 대시보드 탭을 선택한 경우 처리할 로직을 작성합니다.
//                    true
//                }
//                R.id.navigation_mypage -> {
//                    // 알림 탭을 선택한 경우 처리할 로직을 작성합니다.
//                    true
//                }
//                else -> false
//            }
//        }
//
//        // 선택되지 않은 아이콘 색상을 회색으로 지정합니다.
//        navigationView.itemIconTintList = resources.getColorStateList(R.color.bottom_nav_color)
//        Log.d("MY_TAG", "This is my log message")
//        navigationView.selectedItemId = R.id.navigation_home
//
//        initViewPager()
//    }
//
//    private fun initViewPager() {
//        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
//        val viewPagerAdapter = ViewPagerAdapter(this)
//        viewPager.adapter = viewPagerAdapter
//    }
//
//
//}