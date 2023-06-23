package com.example.roomins

import android.content.Intent
import com.example.roomins.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    private lateinit var linearLayout: LinearLayout
    private lateinit var button: Button
    private lateinit var cancelButton: ImageButton
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        linearLayout = findViewById(R.id.visible_page) // LinearLayout의 ID를 가져옵니다.
        button = findViewById(R.id.signup_button)
        cancelButton = findViewById(R.id.cancel_button)

        var idlogin = findViewById<Button>(R.id.idlogin)



        linearLayout.visibility = View.GONE

        idlogin.setOnClickListener {
            val intent = Intent(this, IdLogin::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            linearLayout.visibility = View.VISIBLE
        }
        cancelButton.setOnClickListener {
            linearLayout.visibility = View.GONE
        }
        button.setOnClickListener({
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)

        })


    }
}
