package com.example.room

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.roomins.R

class Passport : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passport)
        val text_edit_noice = findViewById<TextView>(R.id.edit)

        val content = text_edit_noice.text.toString();
        val spannableString = SpannableString(content);

        val world = "여권"
        val start = content.indexOf(world)
        val end = start + world.length;
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#FF617D")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        text_edit_noice.setText(spannableString);

    }
}