package com.example.roomins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.roomins.R.id.textView6

class RegisteredHotelMap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registered_hotel_map)
        val t = findViewById<LinearLayout>(R.id.br_front)
        val parentLayout = t.parent as ViewGroup
        parentLayout.bringChildToFront(t)
    }
}
    