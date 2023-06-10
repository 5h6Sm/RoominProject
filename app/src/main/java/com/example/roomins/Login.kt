package com.example.roomins

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
class Login : AppCompatActivity() {
    private lateinit var linearLayout: LinearLayout
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        linearLayout = findViewById(R.id.visible_page) // 수정된 부분
        button = findViewById(R.id.signup_button)

        button.setOnClickListener {
            linearLayout.visibility = View.VISIBLE
        }
    }
}
