package com.example.roomins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.ImageButton


class HomeActivity : AppCompatActivity() {
    private lateinit var showFragmentButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            showHomeFragment()
        }

        showFragmentButton = findViewById(R.id.button6)
        showFragmentButton.setOnClickListener {
            showHomeFragment()
        }
    }

    private fun showHomeFragment() {
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .addToBackStack(null)
            .commit()
    }
}
