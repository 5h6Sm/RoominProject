package com.example.roomins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton

class ConciergeCall : AppCompatActivity() {
    var dataArr = arrayOf("방키, 열쇠 분실", "소음공해 신고", "방 전등 고장", "신문, 잡지 제공", "기타")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concierge_call)

        val button_select = findViewById<AppCompatButton>(R.id.button_select)

        button_select.setOnClickListener {
            var serviceintent: ImageButton = findViewById(R.id.service_intent)
            serviceintent.setOnClickListener {
                val intent = Intent(this, ServiceFragment::class.java)
                startActivity(intent)
            }

        }
    }
}