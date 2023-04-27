package com.example.roomins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.roomins.R.id.textView6

class RegisteredHotelMap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registered_hotel_map)
        val t = findViewById<TextView>(R.id.textView6);
        t.bringToFront();
    }
}
    