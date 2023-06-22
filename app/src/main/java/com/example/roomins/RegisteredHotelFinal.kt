package com.example.roomins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class RegisteredHotelFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registered_hotel_final)

        val name = findViewById<EditText>(R.id.name).text
        val phone = findViewById<EditText>(R.id.phone_num).text

        val send = findViewById<Button>(R.id.send)
        send.setOnClickListener{
//            val intent = Intent(this@RegisteredHotelFinal, MyHotel::class.java)
            startActivity(intent)
        }

    }
}
    