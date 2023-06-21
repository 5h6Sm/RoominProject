package com.example.roomins

import MyFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val fl: FrameLayout by lazy {
        findViewById(R.id.fl_)
    }

    private val bn: BottomNavigationView by lazy {
        findViewById(R.id.bn_)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // supportFragmentManager.beginTransaction().add(fl.id, HomeFragment()).commit()

        bn.setOnNavigationItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.menu_home -> HomeFragment()
                    R.id.menu_roomin -> RoominFragment()
                    R.id.menu_service -> ServiceFragment()
                    else -> MyFragment()
                }
            )
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(fl.id, fragment).commit()
    }
}